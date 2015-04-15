package com.euromoney.ConsoleContent;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

/**
 * TextPhrase.java
 */
public class TextPhrase {

    private final LinkedHashMap<String, Object> textPhrase = new LinkedHashMap<String, Object>();

    private final Iterator textPhraseIterator;

    public TextPhrase(String phrase) {
        initialiseTextPhrase(removeSpecialCharacters(phrase));
        textPhraseIterator = textPhrase.keySet().iterator();
    }

    public String getNextWord() {
        return (String) textPhraseIterator.next();
    }

    public boolean isMoreWords() {
        return textPhraseIterator.hasNext();
    }

    public String getTextPhrase() {
        StringBuilder output = new StringBuilder();
        Iterator phraseIterator = textPhrase.keySet().iterator();
        while (phraseIterator.hasNext()) {
            output.append(phraseIterator.next());
            output.append(" ");
        }
        //remove the last space
        output.setLength(output.length() - 1);
        return output.toString();
    }

    private void initialiseTextPhrase(String phrase) {
        StringTokenizer st = new StringTokenizer(phrase, " ");
        while (st.hasMoreElements()) {
            textPhrase.put((String)st.nextElement(), null);
        }
    }

    private String removeSpecialCharacters(String phrase) {
        return phrase.replaceAll("[^\\w\\s]","");
    }

}
