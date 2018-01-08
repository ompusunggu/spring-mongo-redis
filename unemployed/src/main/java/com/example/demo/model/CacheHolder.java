package com.example.demo.model;

import java.io.Serializable;

/**
 * Created by louis.ompusungu on 10/26/2017.
 */
public class CacheHolder<T> implements Serializable{
  private String hashName;
  private String hashKey;
  private long expireTime = System.currentTimeMillis();
  private T value;

  public String getHashName() {
    return hashName;
  }

  public void setHashName(String hashName) {
    this.hashName = hashName;
  }

  public String getHashKey() {
    return hashKey;
  }

  public void setHashKey(String hashKey) {
    this.hashKey = hashKey;
  }

  public long getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(long expireTime) {
    this.expireTime = expireTime;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}
