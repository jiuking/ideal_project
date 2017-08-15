package org.smart4j.chapter2.bean;

import org.smart4j.chapter2.util.CastUtil;

import java.util.Map;

/**
 * Created by Bravowhale on 2017/7/10.
 */
public class Param {
    private Map<String,Object> paramMap;

    public Param(Map<String ,Object> paramMap){
        this.paramMap = paramMap;
    }

    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }
    public Map<String,Object> getMap(){
        return paramMap;
    }
}
