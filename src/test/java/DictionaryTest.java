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
        boolean isBanned = bannedWordDictionary.isWordInDictionary("horrible");

        //THEN
        Assert.assertEquals(true, isBanned);

    }

    @Test
    public void testThatNormalWordIsNotDetectedInDictionary() {

        //GIVEN
        Dictionary bannedWordDictionary = new Dictionary(Arrays.asList("swine", "bad", "nasty", "horrible"));

        //WHEN
        boolean isBanned = bannedWordDictionary.isWordInDictionary("normal");

        //THEN
        Assert.assertEquals(false, isBanned);

    }

}
