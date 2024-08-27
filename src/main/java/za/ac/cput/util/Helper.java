package za.ac.cput.util;
//Helper.java
//UserProfile Helper class
//Author:Braedon Sidney Mullins(222821825)
//Date:27 March 2024

import java.security.SecureRandom;
import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String s){
        return s == null || s.isEmpty();
    }

    public static String generateId(){
        return UUID.randomUUID().toString();
    }

    public static boolean isZero(int id){
        return id == 0;
    }

    public static Long generateLongId(){
        SecureRandom secureRandom = new SecureRandom();
        return Math.abs(secureRandom.nextLong());
    }

    public static boolean isZeroOrLess(long num){
        return num == 0 || num < 0;
    }
}
