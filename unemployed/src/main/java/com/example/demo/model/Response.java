package com.example.demo.model;

import java.io.Serializable;

/**
 * Created by louis.ompusungu on 10/26/2017.
 */
public class Response<T> implements Serializable {
  private boolean result;
  private T data;
  private String errorCode;
  private String errorDesc;

  public Response(boolean result) {
    this.result = result;
  }

  public boolean isResult() {
    return result;
  }

  public void setResult(boolean result) {
    this.result = result;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorDesc() {
    return errorDesc;
  }

  public void setErrorDesc(String errorDesc) {
    this.errorDesc = errorDesc;
  }
}
