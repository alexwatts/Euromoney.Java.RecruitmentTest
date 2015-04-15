import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * ConsoleHelperTest.java
 */
public class ConsoleHelperTest {

    @Test
    public void testGetYesOrNo() throws IOException {
        //GIVEN
        ConsoleHelper consoleHelper = new ConsoleHelper();

        //WHEN
        addSimualatedInput("Y");
        boolean yesOrNo = consoleHelper.askYesOrNoQuestion();

        //THEN
        Assert.assertEquals(true, yesOrNo);
    }

    @Test
    public void testGetRedefinedDictionary() throws IOException {
        //GIVEN
        ConsoleHelper consoleHelper = new ConsoleHelper();

        //WHEN
        addSimualatedInput("a redefined dictionary");

        List<String> redefinedDictionary = consoleHelper.getRedefinedDictionary();

        //THEN
        Assert.assertEquals(Arrays.asList("a", "redefined", "dictionary"), redefinedDictionary);
    }


    private void addSimualatedInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //System.setIn(System.in);
    }

}
