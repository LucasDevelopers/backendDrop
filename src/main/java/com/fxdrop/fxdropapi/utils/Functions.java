package com.fxdrop.fxdropapi.utils;

public class Functions {
    public static String cleanString(String value){
        value = value.replaceAll("\\D", "");

        return value;
    }
}
