package org.smart4j.chapter2.util;

/**
 * Created by Bravowhale on 2017/7/7.
 */
public class CastUtil {

    public static String castString(Object obj){
        return CastUtil.castString(obj,"");
    }

    public static String castString(Object obj,String defaultValue){
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    public static double castDouble(Object obj){
        return CastUtil.castDouble(obj,0);
    }

    public static double castDouble(Object obj,double defaultValue){
        double doubleValue = defaultValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try{
                    doubleValue = Double.valueOf(strValue);
                }catch (NumberFormatException e){
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    public static long castLong(Object obj){
        return CastUtil.castLong(obj,0);
    }

    public static long castLong(Object obj,long defaultValue){
        long longValue = defaultValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try{
                    longValue = Long.parseLong(strValue);
                }catch (NumberFormatException e){
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }

    public static int castInt(Object obj) {
        return CastUtil.castInt(obj,0);
    }

    public static int castInt(Object obj,int defaultValue) {
        int value = defaultValue;
        if (obj != null){
            String intValue = CastUtil.castString(obj);
            if (StringUtil.isNotEmpty(intValue))
                try {
                    value = Integer.parseInt(intValue);
                }catch (NumberFormatException e){
                    value = defaultValue;
                }
        }
        return value;
    }

    public static boolean castBoolean(Object obj) {
        return CastUtil.castBoolean(obj,false);
    }

    public static boolean castBoolean(Object obj,boolean defaultValue){
        boolean value = defaultValue;
        if(obj != null){
            String booleanValue = castString(obj);
            if (StringUtil.isNotEmpty(booleanValue)){
                try{
                    value = Boolean.parseBoolean(booleanValue);
                }catch (Exception e){
                    value = defaultValue;
                }
            }
        }
        return value;
    }
}
