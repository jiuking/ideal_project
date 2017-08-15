package org.smart4j.chapter2.util;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Bravowhale on 2017/7/10.
 */
public final class CollectionUtil {
    public static boolean isEmpty(Collection<?> collection){
        if(collection == null || collection.isEmpty()){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    public static boolean isNotEmpty(Collection<?> collection){
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Map<?,?> map){
        if (map == null || map.isEmpty()){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static boolean isNotEmpty(Map<?,?> map){
        return !isEmpty(map);
    }
}
