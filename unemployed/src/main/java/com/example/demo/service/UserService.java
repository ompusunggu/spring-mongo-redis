package com.example.demo.service;

import com.example.demo.model.Response;
import com.example.demo.model.dao.User;

/**
 * Created by louis.ompusungu on 10/26/2017.
 */
public interface UserService {

  void insertNewUser(User user);

  Response login (User user);

  Response checkLoginStatus(String username);
}
