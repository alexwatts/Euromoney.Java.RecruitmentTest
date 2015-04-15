package com.euromoney.ConsoleContent;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program {

	/**
	 * Initialises the application in the
	 * console.
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

        List<String> dictionaryWords = Arrays.asList("swine","bad","nasty","horrible");

        System.out.println("\nThe Dictionary Words are " + dictionaryWords + "\n");

        System.out.println("\nWould you like to redefine the dictionary  \n");

        boolean redefineDictionary = ConsoleHelper.askYesOrNoQuestion();

        if (redefineDictionary) {
            dictionaryWords = ConsoleHelper.getRedefinedDictionary();
        }

		Dictionary bannedWordsDictionary = new Dictionary(dictionaryWords);
		TextPhrase textPhrase = new TextPhrase("The weather in Manchester in winter is bad. It rains all the time - it must be horrible for people visiting.");
		int count = 0;

        while (textPhrase.isMoreWords()) {
            if (bannedWordsDictionary.isWordInDictionary(textPhrase.getNextWord())) {
                count++;
            }
        }

		System.out.println("\nScanned the text sequence: " + textPhrase.getTextPhrase() + "\n");
		System.out.println("\nTotal number of banned words: " + count + "\n");
		System.out.println("\nPress ENTER to exit!\n");
		System.in.read();
		System.out.println("\nExiting Application!\n");
	}

}
