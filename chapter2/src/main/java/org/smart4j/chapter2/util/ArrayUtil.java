package org.smart4j.chapter2.util;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * Created by Bravowhale on 2017/7/10.
 */
public final class ArrayUtil {
    public static boolean isEmpty(Object[] fields){
        return lenth(fields) == 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    public static int lenth(Object[] fields){
        return fields == null ? 0 : Array.getLength(fields);
    }

    public static boolean isNotEmpty(Object[] fields){
        return !isEmpty(fields);
    }
}
