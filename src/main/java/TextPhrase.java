import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * TextPhrase.java
 */
public class TextPhrase {

    private String originalPhrase;

    private final ArrayList<String> textPhrase = new ArrayList<String>();

    private final Iterator textPhraseIterator;

    public TextPhrase(String phrase) {
        initialiseTextPhrase(removeSpecialCharacters(phrase));
        textPhraseIterator = textPhrase.iterator();
        this.originalPhrase = phrase;
    }

    public String getNextWord() {
        return (String) textPhraseIterator.next();
    }

    public boolean isMoreWords() {
        return textPhraseIterator.hasNext();
    }

    public String getTextPhrase() {
        StringBuilder output = new StringBuilder();
        Iterator phraseIterator = textPhrase.iterator();
        while (phraseIterator.hasNext()) {
            output.append(phraseIterator.next());
            output.append(" ");
        }
        //remove the last space
        output.setLength(output.length() - 1);
        return output.toString();
    }

    public String getOriginalPhrase() {
        return originalPhrase;
    }

    private void initialiseTextPhrase(String phrase) {
        StringTokenizer st = new StringTokenizer(phrase, " ");
        while (st.hasMoreElements()) {
            String word = (String)st.nextElement();
            textPhrase.add(word);
        }
    }

    private String removeSpecialCharacters(String phrase) {
        return phrase.replaceAll("[^\\w\\s]","");
    }

}
