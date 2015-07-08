package com.goree.api.sample;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goree.api.Application;
import com.goree.api.config.MyBatisConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes={Application.class,MyBatisConfig.class})
public class MyBatisTest {
    @Autowired
    MybatisTestService service;
    
    @Test
    public void selectWithMybatis() {
        FooBar fooBar = service.selectFooBar();
        Assert.assertNotNull(fooBar);
    }
}
