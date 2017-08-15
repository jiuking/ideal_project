package com.hjc.instance;

/**
 * Created by Bravowhale on 2017/8/2.
 */
public class Lazy_Singleton {
    private static Lazy_Singleton instance;
    private Lazy_Singleton(){}
    public static synchronized Lazy_Singleton getInstance(){
        if(instance == null) {
            instance = new Lazy_Singleton();
        }
        return instance;
    }
}
