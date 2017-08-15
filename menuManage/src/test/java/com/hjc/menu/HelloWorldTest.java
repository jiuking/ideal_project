package com.hjc.menu;

import com.hjc.menu.service.HelloWorldServce;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-service.xml",
        "classpath:spring-dao.xml"})
public class HelloWorldTest {
    @Autowired
    private HelloWorldServce helloWorldServce;
    @Test
    public void testHelloWorld(){
        String str = helloWorldServce.printHelloWorld("hello");
        Assert.assertEquals("测试未通过",str,"hello");
    }
}
