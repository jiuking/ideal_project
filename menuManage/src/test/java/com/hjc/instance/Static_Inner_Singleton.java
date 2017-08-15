package com.hjc.instance;

/**
 * Created by Bravowhale on 2017/8/2.
 */
public class Static_Inner_Singleton {
    private Static_Inner_Singleton(){}
    private static class SingletonHolder{
        private final static Static_Inner_Singleton instance = new Static_Inner_Singleton();
    }
    public static Static_Inner_Singleton getInstance(){
        return SingletonHolder.instance;
    }
}
