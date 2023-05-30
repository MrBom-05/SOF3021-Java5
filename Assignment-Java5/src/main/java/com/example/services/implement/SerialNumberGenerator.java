package com.example.services.implement;

import java.util.Random;

public class SerialNumberGenerator {
    public static String generateSerialNumber() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder(10);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            stringBuilder.append(randomChar);
        }
        System.out.println("Serial Number: " + stringBuilder);

        return stringBuilder.toString();
    }
}
