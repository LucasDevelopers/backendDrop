package com.fxdrop.fxdropapi.utils;

public class CpfUtils {

    public static String cleanCpf(String cpf){
        // Remove caracteres não numéricos (pontos, traços, etc)
        cpf = cpf.replaceAll("\\D", "");

        return cpf;
    }

    public static boolean cpfValidate(String cpf) {
        if (cpf == null) {
            return false;
        }

        // Verifica se tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (ex: 11111111111)
        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        try {
            int[] digits = new int[11];
            for (int i = 0; i < 11; i++) {
                digits[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
            }

            // Calcula o primeiro dígito verificador
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += digits[i] * (10 - i);
            }
            int firstVerifier = (sum * 10) % 11;
            if (firstVerifier == 10) firstVerifier = 0;

            if (digits[9] != firstVerifier) {
                return false;
            }

            // Calcula o segundo dígito verificador
            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += digits[i] * (11 - i);
            }
            int secondVerifier = (sum * 10) % 11;
            if (secondVerifier == 10) secondVerifier = 0;

            if (digits[10] != secondVerifier) {
                return false;
            }

            return true;

        } catch (NumberFormatException e) {
            // CPF contém caracteres inválidos
            return false;
        }
    }
}
