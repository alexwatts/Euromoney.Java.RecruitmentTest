package com.euromoney.ConsoleContent;

import junit.framework.Assert;
import org.junit.Test;

/**
 * TextPhraseTest.java
 */
public class TextPhraseTest {

    @Test
    public void testThatPhraseTextExtractsPhraseText() {
        //GIVEN
        TextPhrase textPhrase = new TextPhrase("a text phrase");

        //WHEN
        String word = textPhrase.getNextWord();

        //THEN
        Assert.assertEquals("a", word);
    }

    @Test
    public void testThatPhraseTextExtractsMiddlePhraseText() {
        //GIVEN
        TextPhrase textPhrase = new TextPhrase("a text phrase");
        textPhrase.getNextWord();

        //WHEN
        String word = textPhrase.getNextWord();

        //THEN
        Assert.assertEquals("text", word);
    }

    @Test
    public void testThatPhraseTextExtractsEndPhraseText() {
        //GIVEN
        TextPhrase textPhrase = new TextPhrase("a text phrase");
        textPhrase.getNextWord();

        //WHEN
        String word = textPhrase.getNextWord();

        //THEN
        Assert.assertEquals("phrase", word);
    }

    @Test
    public void testThatPhraseTextEndFlagIsWorkingDuringPhrase() {
        //GIVEN
        TextPhrase textPhrase = new TextPhrase("a text phrase");

        //WHEN
        boolean isMore = textPhrase.isMoreWords();

        //THEN
        Assert.assertEquals(true, isMore);
    }

    @Test
    public void testThatPhraseTextEndFlagIsWorkingAtEndOfPhrase() {
        //GIVEN
        TextPhrase textPhrase = new TextPhrase("a text phrase");
        textPhrase.getNextWord();
        textPhrase.getNextWord();
        textPhrase.getNextWord();

        //WHEN
        boolean isMore = textPhrase.isMoreWords();

        //THEN
        Assert.assertEquals(false, isMore);
    }
}
