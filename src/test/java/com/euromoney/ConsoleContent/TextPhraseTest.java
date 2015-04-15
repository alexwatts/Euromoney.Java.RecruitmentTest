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
        textPhrase.getNextWord();

        //WHEN
        String word = textPhrase.getNextWord();

        //THEN
        Assert.assertEquals("phrase", word);
    }

    @Test()
    public void testThatPhraseTextIsMoreWordIsWorkingDuringPhrase() {
        //GIVEN
        TextPhrase textPhrase = new TextPhrase("a text phrase");


        //WHEN
        boolean isMoreWords = textPhrase.isMoreWords();

        //THEN
        Assert.assertEquals(true, isMoreWords);
    }

    @Test()
    public void testThatPhraseTextIsMoreWordIsWorkingAtEndOfPhrase() {
        //GIVEN
        TextPhrase textPhrase = new TextPhrase("a text phrase");
        textPhrase.getNextWord();
        textPhrase.getNextWord();
        textPhrase.getNextWord();

        //WHEN
        boolean isMoreWords = textPhrase.isMoreWords();

        //THENs
        Assert.assertEquals(false, isMoreWords);
    }


    @Test(expected = java.util.NoSuchElementException.class)
    public void testThatPhraseTextThrowsExceptionAtEndOfPhrase() {
        //GIVEN
        TextPhrase textPhrase = new TextPhrase("a text phrase");
        textPhrase.getNextWord();
        textPhrase.getNextWord();
        textPhrase.getNextWord();

        //WHEN
        String word = textPhrase.getNextWord();

        //THEN
        //@Test(expected = java.util.NoSuchElementException.class)
    }

    @Test()
    public void testTextPhraseGetOutputWorks() {
        //GIVEN
        TextPhrase textPhrase = new TextPhrase("a text phrase");


        //WHEN
        String textPhraseToTest = textPhrase.getTextPhrase();

        //THEN
        Assert.assertEquals("a text phrase", textPhraseToTest);
    }

    @Test()
    public void testThatTextPhraseFiltersSpecialCharacters() {
        //GIVEN
        TextPhrase textPhrase = new TextPhrase("a.. text// phrase---");


        //WHEN
        String textPhraseToTest = textPhrase.getTextPhrase();

        //THEN
        Assert.assertEquals("a text phrase", textPhraseToTest);
    }

}
