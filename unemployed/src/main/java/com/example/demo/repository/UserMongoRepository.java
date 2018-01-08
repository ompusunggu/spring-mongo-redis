package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.dao.User;

/**
 * Created by louis.ompusungu on 10/26/2017.
 */
public interface UserMongoRepository extends MongoRepository<User, String> {

  User findUserByUsernameAndPassword(String username, String password);
}
