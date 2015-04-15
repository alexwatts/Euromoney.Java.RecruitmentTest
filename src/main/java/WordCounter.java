/**
 * WordCounter.java
 */
public class WordCounter {

    private final Dictionary dictionary;

    private final TextPhrase textPhrase;

    private StringBuilder outputPhrase = new StringBuilder();

    private int count;

    public WordCounter(Dictionary dictionary, TextPhrase textPhrase) {
        this.dictionary = dictionary;
        this.textPhrase = textPhrase;
        process();
    }

    public String getOutput() {
        return outputPhrase.toString();
    }

    public int getBadWordCount() {
        return count;
    }

    private void process() {
        while (textPhrase.isMoreWords()) {
            String word = textPhrase.getNextWord();
            if (dictionary.isWordInDictionary(word)) {
                count++;
                outputPhrase.append(replaceBadWordWithHashes(word));
                outputPhrase.append(" ");
            } else {
                outputPhrase.append(word);
                outputPhrase.append(" ");
            }
        }
        //remove last space
        outputPhrase.setLength(outputPhrase.length() -1);
    }

    private String replaceBadWordWithHashes(String badWord) {
        if (badWord.length() == 1) return "#";

        if (badWord.length() == 2) return "##";

        StringBuilder replacement = new StringBuilder();
        replacement.append(badWord.substring(0,1));
        for (int i=1;i<badWord.length() -1; i++) {
            replacement.append("#");
        }
        replacement.append(badWord.substring(badWord.length() -1, badWord.length()));
        return replacement.toString();
    }
}
