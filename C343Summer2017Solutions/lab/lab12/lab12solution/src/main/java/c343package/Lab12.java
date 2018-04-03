package c343package;

import java.util.Hashtable;
import java.io.*;
import java.util.Scanner;


public class Lab12 {



        Hashtable<String, String> myDictionary;

        public Lab12(String link) throws IOException {

            int lLineNumber = 1;
            String lFoundLines;

            File lUrl = new File(link);
            Scanner lInputScanner = new Scanner(lUrl);

            myDictionary = new Hashtable<String, String>();

            while (lInputScanner.hasNext()) {

                String lCurrentTextLine = lInputScanner.nextLine();

                // split the current line into words, around regex matches of any non-word characters:
                String[] lAllWordsInLine = lCurrentTextLine.split("\\W+");

                for (int i = 0; i < lAllWordsInLine.length; i++) {
                    // for each word, has it already been seen?
                    lFoundLines = myDictionary.get(lAllWordsInLine[i]);
                    if (lFoundLines == null) {
                        // if it's a new word, store the current line number
                        lFoundLines = Integer.toString(lLineNumber);
                        myDictionary.put(lAllWordsInLine[i], lFoundLines);
                    }
                    else {
                        // if the word is already in the dictionary,
                        //   add the the current line number to the line numbers already in the dict:
                        lFoundLines += ", " + Integer.toString(lLineNumber);
                        myDictionary.put(lAllWordsInLine[i], lFoundLines);
                    }
                }
                lLineNumber++;
            }
            lInputScanner.close();
        }

        public void wordQuery(String word) {
            String lines = new String();
            lines = myDictionary.get(word);
            if (lines != null) {
                System.out.println(word + " is found in lines: " + lines);
            } else {
                System.out.println(word + " not found. ");
            }
        }

        public static void main(String args[]) throws IOException {
            // read document, store string
            Lab12 mytxt = new Lab12("lab-12-testing.txt");
            mytxt.wordQuery("algorithm");
            mytxt.wordQuery("data");
    }


}


