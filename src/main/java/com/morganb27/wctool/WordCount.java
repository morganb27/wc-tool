package com.morganb27.wctool;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;

public class WordCount {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: ccwc -w|-c|-l|-m <filename>");
            return;
        }

        String option = args[0];
        String filename = args[1];
        String content = Files.readString(Path.of(filename));

        switch (option) {
            case "-c":
                long countBytes = WordCount.countBytes(filename);
                System.out.printf("%d %s%n", countBytes, filename);
                break;
            case "-l":
                int countLines = WordCount.countLines(filename);
                System.out.printf("%d %s%n", countLines, filename);
                break;
            case "-w":
                int countWord = WordCount.countWords(content);
                System.out.printf("%d %s%n", countWord, filename);
                break;
            case "-m":
                int countChar = WordCount.countCharacters(filename);
                System.out.printf("%d %s%n", countChar, filename);
                break;
            case "-a":
                System.out.printf("%d %d %d %s%n", WordCount.countLines(filename), WordCount.countWords(content), WordCount.countBytes(filename), filename);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }

    }

    public static long countBytes(String input) throws IOException {
        if (input == null) {
            throw new IllegalArgumentException("String argument cannot be null.");
        }

        FileChannel fileChannel = FileChannel.open(Path.of(input));
        return fileChannel.size();
    }

    public static int countLines(String input) throws IOException {
        if (input == null) {
            throw new IllegalArgumentException("String argument cannot be null.");
        }
        return Files.readAllLines(Path.of(input)).size();
    }

    public static int countWords(String input) {
        if (input == null) {
            throw new IllegalArgumentException("String argument cannot be null.");
        }
        return input.split("\\s+").length;
    }

    public static int countCharacters(String input) throws IOException {
        if (input == null) {
            throw new IllegalArgumentException("String argument cannot be null.");
        }
        return Files.readString(Path.of(input)).length();
    }
}