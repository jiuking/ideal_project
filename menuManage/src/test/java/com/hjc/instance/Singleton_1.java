package com.hjc.instance;

/**
 * Created by Bravowhale on 2017/8/2.
 */
//hungry  pattern
public class Singleton_1 {
    private final static Singleton_1 instance = new Singleton_1();
    private Singleton_1(){}
    public static Singleton_1 getInstance(){
        return instance;
    }
}
