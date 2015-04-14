package com.euromoney.ConsoleContent;

import java.util.HashMap;
import java.util.List;

/**
 * Dictionary.java
 *
 * This is dictionary of bad words.
 */
public class Dictionary {

    private HashMap<String, Object> dictionary = new HashMap<String, Object>();

    public Dictionary(List<String> bannedWords) {
        initialiseDictionaryWithBannedWords(bannedWords);
    }

    public boolean isWordInDictionary(String word) {
        return dictionary.containsKey(word);
    }

    private void initialiseDictionaryWithBannedWords(List<String> bannedWords) {
        for (String word: bannedWords) {
            dictionary.put(word, null);
        }
    }

}
