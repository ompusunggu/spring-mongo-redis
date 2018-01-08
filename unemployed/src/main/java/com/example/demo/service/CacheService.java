package com.example.demo.service;

import com.example.demo.model.CacheHolder;

/**
 * Created by louis.ompusungu on 10/26/2017.
 */
public interface CacheService {

  Integer DEFAULT_EXPIRY_DURATION_IN_SECONDS = 300;

  <T extends Object>CacheHolder<T> getCache(String name, String key, Class<T> type);

  void save(CacheHolder cacheHolder);
}
