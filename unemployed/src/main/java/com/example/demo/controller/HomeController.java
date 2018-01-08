package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Response;
import com.example.demo.service.CommonService;

/**
 * Created by louis.ompusungu on 10/26/2017.
 */
@RestController
@RequestMapping(value="/home",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class HomeController {

  @Autowired
  CommonService commonService;

  @RequestMapping(value="/", method = RequestMethod.GET)
  public Response connectionCheck(){
    try{

      commonService.insertNewVisitorCount();
      return new Response(Boolean.TRUE);
    }catch(Exception e){
      return new Response(Boolean.FALSE);
    }
  }

}
