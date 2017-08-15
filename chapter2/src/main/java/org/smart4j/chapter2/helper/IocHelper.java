package org.smart4j.chapter2.helper;

import org.smart4j.chapter2.annotation.Inject;
import org.smart4j.chapter2.util.ArrayUtil;
import org.smart4j.chapter2.util.CollectionUtil;
import org.smart4j.chapter2.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bravowhale on 2017/7/10.
 */
public final class IocHelper {
    static {
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)){
            for (Map.Entry<Class<?>,Object> entry : beanMap.entrySet()){
                Class<?> beanClass = entry.getKey();
                Object beanInstance = entry.getValue();
                Field[] beanFileds = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFileds)){
                    for (Field beanField : beanFileds){
                        if (beanField.isAnnotationPresent(Inject.class)){
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFiledInstance = beanMap.get(beanFieldClass);
                            if(beanFieldClass != null){
                                ReflectionUtil.setFiled(beanInstance,beanField,beanFiledInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
