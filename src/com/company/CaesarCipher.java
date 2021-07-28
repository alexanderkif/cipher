package com.company;

import java.util.Arrays;
import java.util.stream.Collector;

public class CaesarCipher implements Cipher {

    private static final String LETTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    @Override
    public String encript(String string) {
        StringBuilder allDecodes = new StringBuilder();
        for (int offset = 1; offset < LETTERS.length(); offset++) {
            allDecodes.append("Смещение ")
                    .append(offset)
                    .append("\n\n")
                    .append(encriptWithOffset(string, offset))
                    .append("\n\n");
        }
        return allDecodes.toString();
    }

    private String encriptWithOffset(String string, int offset) {
        return Arrays.stream(string.split("")).map(symbol -> {
            int position = LETTERS.indexOf(symbol.toLowerCase().charAt(0));
            if (position == -1) {
                return symbol;
            }
            char newChar = LETTERS.charAt((position + offset) % LETTERS.length());
            if (symbol.toUpperCase().equals(symbol)) {
                return Character.toUpperCase(newChar);
            } else {
                return newChar;
            }
        }).collect(Collector.of(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString));
    }
}
