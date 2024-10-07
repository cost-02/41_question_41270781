package com.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class MD5Hashing {
    public static String getMD5(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(input.getBytes("UTF-8"));  // Specifica UTF-8 come codifica
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashtext = bigInt.toString(16);
        // Aggiungi zeri iniziali per mantenere la lunghezza del digest a 32 caratteri
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        try {
            String input = "test'ing"; // Esempio con apostrofo
            System.out.println("MD5 Hash: " + getMD5(input));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
