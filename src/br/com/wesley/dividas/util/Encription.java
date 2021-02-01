package br.com.wesley.dividas.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Encription {

    public static String getMD5(String str) {
        try {
            // Generate an MD5 encrypted calculation summary
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Calculate md5 function
            md.update(str.getBytes());
            // digest() finally determines to return the md5 hash value, and the return value is 8 as a string. Because the md5 hash value is a 16-bit hex value, which is actually an 8-bit character
            // The BigInteger function converts an 8-bit string into a 16-bit hex value, which is represented by a string; the hash value in the form of a string is obtained
            String md5 = new BigInteger(1, md.digest()).toString(16);
            //BigInteger will omit 0, need to complete to 32
            return fillMD5(md5);
        } catch (Exception e) {
            throw new RuntimeException("MD5 encryption error:" + e.getMessage(), e);
        }
    }

    public static String fillMD5(String md5) {
        return md5.length() == 32 ? md5 : fillMD5("0" + md5);
    }

    public static String convertMD5(String inStr) {

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }

}
