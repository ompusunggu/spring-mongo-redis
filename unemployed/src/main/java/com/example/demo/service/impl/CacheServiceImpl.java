package com.example.demo.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.model.CacheHolder;
import com.example.demo.service.CacheService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;

/**
 * Created by louis.ompusungu on 10/26/2017.
 */
@Service
public class CacheServiceImpl implements CacheService {

  private static final ObjectMapper OBJECT_MAPPER;

  static {
    final JsonFactory jsonFactory = new JsonFactory();
    OBJECT_MAPPER = new ObjectMapper(jsonFactory);
    CacheServiceImpl.OBJECT_MAPPER.addHandler(new DeserializationProblemHandler() {
      @Override
      public boolean handleUnknownProperty(DeserializationContext ctxt, JsonParser jp,
          JsonDeserializer<?> deserializer, Object beanOrClass, String propertyName)
          throws IOException, JsonProcessingException {
        return true;
      }
    });
  }

  @Autowired
  RedisTemplate redisTemplate;

  public <T extends Object> CacheHolder<T> getCache(String name, String key, Class<T> type) {
    String value = (String) redisTemplate.opsForHash().get(name, key);
    if (!StringUtils.isEmpty(value)) {
      try {
        JavaType javaType =
            OBJECT_MAPPER.getTypeFactory().constructParametricType(CacheHolder.class, type);
        CacheHolder<T> cache = OBJECT_MAPPER.readValue(value, javaType);
        if (cache.getExpireTime() < System.currentTimeMillis()) {
          return null;
        }
        return cache;
      } catch (Exception e) {
        return null;
      }
    }
    return null;
  }

  public void save(CacheHolder cacheHolder){
    try {
      // expiry time is in milisecond so multiply expiryDuration with 1000
      cacheHolder.setExpireTime(System.currentTimeMillis() + (cacheHolder.getExpireTime() * 1000));
      final String value = OBJECT_MAPPER.writeValueAsString(cacheHolder);
      redisTemplate.opsForHash().put(cacheHolder.getHashName(), cacheHolder.getHashKey(), value);
    } catch (final JsonProcessingException ex) {

    }
  }
}
