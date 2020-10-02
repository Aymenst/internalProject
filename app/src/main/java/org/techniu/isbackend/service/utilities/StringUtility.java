package org.techniu.isbackend.service.utilities;

public class StringUtility {

    public static String capitalize(String str) {
        if(str == null || str.isEmpty() || str.isBlank()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String UpperCase(String str) {
        if(str == null || str.isEmpty() || str.isBlank()) {
            return str;
        }
        return str.toUpperCase();
    }
    public static String LowerCase(String str) {
        if(str == null || str.isEmpty() || str.isBlank()) {
            return str;
        }
        return str.toLowerCase();
    }

}
