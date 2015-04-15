import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * WordCounterTest.java
 */
public class WordCounterTest {

    @Test
    public void testThatWordCounterCountsCorrectly() {
        //GIVEN
        Dictionary bannedWordDictionary = new Dictionary(Arrays.asList("swine", "bad", "nasty", "horrible"));
        TextPhrase textPhrase = new TextPhrase("bad nothing horrible airplane");

        //WHEN
        WordCounter wordCounter = new WordCounter(bannedWordDictionary, textPhrase);

        //
        Assert.assertEquals(2, wordCounter.getBadWordCount());
    }

    @Test
    public void testThatWordCounterHashesWordsCorrectly() {
        //GIVEN
        Dictionary bannedWordDictionary = new Dictionary(Arrays.asList("swine", "bad", "nasty", "horrible", "aa", "b"));
        TextPhrase textPhrase = new TextPhrase("bad nothing horrible airplane aa b");

        //WHEN
        WordCounter wordCounter = new WordCounter(bannedWordDictionary, textPhrase);

        //
        Assert.assertEquals("b#d nothing h######e airplane ## #", wordCounter.getOutput());
    }


}
