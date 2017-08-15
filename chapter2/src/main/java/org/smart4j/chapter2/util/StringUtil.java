package org.smart4j.chapter2.util;

/**
 * Created by Bravowhale on 2017/7/7.
 */
public class StringUtil {
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
    public static boolean isEmpty(String str){
        if (str == null || str.trim().equals(""))
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    public static String[] splitString(String origin,String split){
        return origin.split(split);
    }
}
