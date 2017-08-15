package com.hjc.instance;

/**
 * Created by Bravowhale on 2017/8/2.
 */
public class Double_Check_Singleton {
    private static volatile Double_Check_Singleton instance;
    private Double_Check_Singleton(){}
    public static Double_Check_Singleton getInstance(){
        if (instance == null){
             synchronized (Double_Check_Singleton.class){
                if (instance == null)
                    instance = new Double_Check_Singleton();
             }
        }
        return instance;
    }
}

