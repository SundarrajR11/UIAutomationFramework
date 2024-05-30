package com.ecom.utils;

public final class DynamicXpath {
    private DynamicXpath(){
    }
    public static String getXpath(String comXpath, String replaceValue){
        return  String.format(comXpath,replaceValue);
    }
}
