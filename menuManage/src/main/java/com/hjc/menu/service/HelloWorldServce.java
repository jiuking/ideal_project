package com.hjc.menu.service;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/16.
 */
@Service
public class HelloWorldServce
{
    public String  printHelloWorld(String str){
        System.out.println(str);
        return str;
    }
}
