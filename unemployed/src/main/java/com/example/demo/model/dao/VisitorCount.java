package com.example.demo.model.dao;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by louis.ompusungu on 10/26/2017.
 */
@Document(collection = "visitor")
public class VisitorCount {

  @Id
  private long id;

  private Date date;

  private long count;

  public VisitorCount() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }

}
