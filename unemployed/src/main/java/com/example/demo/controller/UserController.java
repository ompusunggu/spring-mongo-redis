package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Response;
import com.example.demo.model.dao.User;
import com.example.demo.service.UserService;

/**
 * Created by louis.ompusungu on 10/26/2017.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public Response login(@RequestBody User user){
    return userService.login(user);
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String register(@RequestBody User user){
    userService.insertNewUser(user);
    return user.getUsername();
  }

  @RequestMapping(value = "/status", method = RequestMethod.GET)
  public Response checkLoginStatus(@RequestParam String username){
    username = username.toLowerCase();
    return userService.checkLoginStatus(username);
  }
}
