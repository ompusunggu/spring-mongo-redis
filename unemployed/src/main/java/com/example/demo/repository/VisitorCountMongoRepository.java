package com.example.demo.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.dao.VisitorCount;

/**
 * Created by louis.ompusungu on 10/26/2017.
 */
public interface VisitorCountMongoRepository extends MongoRepository<VisitorCount,Long> {

  VisitorCount findByDate(Date date);
}
