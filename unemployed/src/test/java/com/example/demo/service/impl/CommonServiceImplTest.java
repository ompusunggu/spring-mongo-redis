package com.example.demo.service.impl;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.demo.model.dao.VisitorCount;
import com.example.demo.repository.VisitorCountMongoRepository;

/**
 * Created by louis.ompusungu on 10/26/2017.
 */
public class CommonServiceImplTest {
  @InjectMocks
  CommonServiceImpl commonService;

  @Mock
  VisitorCountMongoRepository visitorCountMongoRepository;

  @Before
  public void setUp() throws Exception {
    initMocks(this);

  }

  @Test
  public void insertNewVisitorCount() throws Exception {
    when(visitorCountMongoRepository.save(any(VisitorCount.class))).thenReturn(new VisitorCount());
    commonService.insertNewVisitorCount();
  }
}