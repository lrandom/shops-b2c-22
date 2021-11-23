package com.example.shopsb2c22.services;

public class Helper {
    public static final String BASE_URL = "http://localhost:8080/shops-b2c-22-1.0-SNAPSHOT/";
    public static String getMd5(String plainText) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(plainText.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
