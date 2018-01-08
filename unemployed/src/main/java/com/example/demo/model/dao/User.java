package com.example.demo.model.dao;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by louis.ompusungu on 10/26/2017.
 */
@Document(collection = "user")
public class User implements Serializable{

  private static final long serialVersionUID = 1453772281898832290L;

  @Id
  private String id;
  private String username;
  private String password;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("User{");
    sb.append("id='").append(id).append('\'');
    sb.append(", username='").append(username).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
