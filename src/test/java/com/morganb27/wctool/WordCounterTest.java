package com.morganb27.wctool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    public void testCountWord() {
        String input = "Hello world";
        int wordCount = WordCount.countWords(input);
        assertEquals(2, wordCount, "Expected wordCount to equal 2");
    }
}
