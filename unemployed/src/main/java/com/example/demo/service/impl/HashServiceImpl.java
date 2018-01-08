package com.example.demo.service.impl;

import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

import com.example.demo.constant.Constant;
import com.example.demo.service.HashService;
import com.google.common.hash.Hashing;

/**
 * Created by louis.ompusungu on 10/26/2017.
 */
@Service
public class HashServiceImpl implements HashService{

  @Override
  public String hash(String source){
      source+= Constant.HASH_SALT;

      return Hashing.sha256()
        .hashString(source, StandardCharsets.UTF_8)
        .toString();
  }
}
