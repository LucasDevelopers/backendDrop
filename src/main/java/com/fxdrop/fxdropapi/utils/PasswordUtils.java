package com.fxdrop.fxdropapi.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {
    public static String passwordEncode(String password){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte [] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b: hash){
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e){
            throw new RuntimeException("Erro ao encriptar a senha", e);
        }
    }

    public static boolean verifyPassword(String rawPassword, String encodedPassword) {
        String encodedRaw = passwordEncode(rawPassword);
        return encodedRaw.equals(encodedPassword);
    }
}
