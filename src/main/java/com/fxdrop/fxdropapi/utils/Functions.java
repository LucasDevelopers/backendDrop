package com.fxdrop.fxdropapi.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Functions {
    public static String cleanString(String value){
        value = value.replaceAll("\\D", "");

        return value;
    }

    public static boolean isValidCnpj(String cnpj) {

        // Check if length is 14
        if (cnpj.length() != 14) {
            return false;
        }

        // Check if all digits are the same (invalid case)
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        try {
            int[] weight1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] weight2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

            int sum = 0;
            for (int i = 0; i < 12; i++) {
                sum += Character.getNumericValue(cnpj.charAt(i)) * weight1[i];
            }
            int remainder = sum % 11;
            char checkDigit1 = (remainder < 2) ? '0' : (char) ((11 - remainder) + '0');

            sum = 0;
            for (int i = 0; i < 13; i++) {
                sum += Character.getNumericValue(cnpj.charAt(i)) * weight2[i];
            }
            remainder = sum % 11;
            char checkDigit2 = (remainder < 2) ? '0' : (char) ((11 - remainder) + '0');

            // Check both verification digits
            return (cnpj.charAt(12) == checkDigit1 && cnpj.charAt(13) == checkDigit2);

        } catch (Exception e) {
            return false;
        }
    }

    public static String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
}
