package com.morganb27.wctool;

public class WordCount {
    public static void main(String[] args) {

    }

    public static int countWords(String input) {
        if (input == null) {
            throw new IllegalArgumentException("String argument cannot be null.");
        }

        if (input.isEmpty()) {
            return 0;
        }

        return input.split("\\s+").length;
    }
}