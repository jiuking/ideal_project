package org.smart4j.chapter2;

import org.smart4j.chapter2.annotation.Controller;
import org.smart4j.chapter2.helper.*;
import org.smart4j.chapter2.util.ClassUtil;

/**
 * Created by Bravowhale on 2017/7/10.
 */
public final class HelperLoader {
    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList){
            ClassUtil.loadClass(cls.getName());
        }
    }
}
