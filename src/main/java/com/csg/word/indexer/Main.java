package main.java.com.csg.word.indexer;

import main.java.com.csg.word.indexer.io.FileReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            if (args == null || args.length == 0) {
                throw new IllegalArgumentException("Must fill arguments (ex. java -jar word-indexer-csg.java filetest1.txt)");
            }

            FileReader fileReader = new FileReader();

            for (String fileName : args) {
                try {
                    List<String> words = fileReader.readWordsFromFile(fileName);
                    for (String word : words) {
                        System.out.println(word);
                    }
                } catch (Exception e) {
                    System.err.println("Error processing file " + fileName + ": " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

}
