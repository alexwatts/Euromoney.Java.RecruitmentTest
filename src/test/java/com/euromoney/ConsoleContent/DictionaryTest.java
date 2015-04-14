package com.euromoney.ConsoleContent;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * DictionaryTest.java
 */
public class DictionaryTest {

    @Test
    public void testThatABannedWordIsDetectedInDictionary() {

        //GIVEN
        Dictionary bannedWordDictionary = new Dictionary(Arrays.asList("swine","bad","nasty","horrible"));

        //WHEN
        boolean isBanned = bannedWordDictionary.isWordInDictionary("bad");

        //THEN
        Assert.assertEquals(true, isBanned);

    }
}
