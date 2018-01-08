package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.constant.Constant;
import com.example.demo.model.CacheHolder;
import com.example.demo.model.Response;
import com.example.demo.model.dao.User;
import com.example.demo.repository.UserMongoRepository;
import com.example.demo.service.CacheService;
import com.example.demo.service.HashService;
import com.example.demo.service.UserService;

/**
 * Created by louis.ompusungu on 10/26/2017.
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserMongoRepository userMongoRepository;

  @Autowired
  HashService hashService;

  @Autowired
  RedisTemplate redisTemplate;

  @Autowired
  CacheService cacheService;

  @Override
  public void insertNewUser(User user){
    user.setPassword(hashService.hash(user.getPassword()));
    userMongoRepository.save(user);
  }

  @Override
  public Response login(User userRequest) {
    Response response = new Response(Boolean.TRUE);
    User userDao = userMongoRepository.findUserByUsernameAndPassword(userRequest.getUsername(),
        hashService.hash(userRequest.getPassword()));
    if(userDao != null){
      CacheHolder<User> cache =  new CacheHolder<>();
      cache.setValue(userDao);
      cache.setHashKey(Constant.USER_CACHE_KEY_PREFIX+ userDao.getUsername());
      cache.setHashName(Constant.USER_CACHE_NAME_PREFIX+ userDao.getUsername());
      cache.setExpireTime(cache.getExpireTime()+Constant.USER_CACHE_EXPIRY_TIME);
      cacheService.save(cache);
    }
    response.setData(userDao);
    return response;

  }

  @Override
  public Response checkLoginStatus(String username){
    Response response = new Response(Boolean.TRUE);
    response.setData("LOGGED_IN");
    CacheHolder cache = cacheService.getCache(Constant.USER_CACHE_NAME_PREFIX+username, Constant.USER_CACHE_KEY_PREFIX+username, User.class);
    if(cache == null){
      response.setResult(Boolean.FALSE);
      response.setData("LOGGED_OUT");
    }
    return response;
  }
}
