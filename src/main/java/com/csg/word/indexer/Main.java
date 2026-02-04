package main.java.com.csg.word.indexer;

import main.java.com.csg.word.indexer.io.FileReader;
import main.java.com.csg.word.indexer.model.IndexedWord;
import main.java.com.csg.word.indexer.validation.IValidation;
import main.java.com.csg.word.indexer.orchestrator.ValidationOrchestrator;
import main.java.com.csg.word.indexer.validation.imp.LongWordValidation;
import main.java.com.csg.word.indexer.validation.imp.UppercaseWordValidation;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private ValidationOrchestrator registerValidations() {
        List<IValidation> validations = new ArrayList<>();
        validations.add(new UppercaseWordValidation());
        validations.add(new LongWordValidation());

        return new ValidationOrchestrator(validations);
    }

    private void printResult(IndexedWord indexedWord, String fileName) {
        System.out.println("File: " + fileName);
        System.out.println("Uppercase words count: " + indexedWord.getUppercaseWordCount());
        System.out.println("Words longer than 5 characters:");
        indexedWord.getLongWordSet().forEach(System.out::println);
        System.out.println();
    }

    public Main(String[] args) {
        try {
            if (args == null || args.length == 0) {
                throw new IllegalArgumentException("Must fill arguments (ex. java -jar word-indexer-csg.java filetest1.txt)");
            }

            FileReader fileReader = new FileReader();
            ValidationOrchestrator engine = registerValidations();

            for (String fileName : args) {
                try {
                    List<String> words = fileReader.readWordsFromFile(fileName);
                    IndexedWord indexedWord = engine.run(words);

                    printResult(indexedWord, fileName);
                } catch (Exception e) {
                    System.err.println("Error processing file " + fileName + ": " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    static void main(String[] args) {
        new Main(args);
    }

}
