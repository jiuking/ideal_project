package org.smart4j.chapter2.annotation;

import java.lang.annotation.*;

/**
 * Created by Bravowhale on 2017/7/11.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
