package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.VisitorCountMongoRepository;
import com.example.demo.service.CommonService;

/**
 * Created by louis.ompusungu on 10/26/2017.
 */
@Service
public class CommonServiceImpl implements CommonService {

  @Autowired
  VisitorCountMongoRepository visitorCountMongoRepository;

  @Override
  public void visitorCounter(){

  }

  @Override
  public void insertNewVisitorCount() throws Exception{
  }
}
