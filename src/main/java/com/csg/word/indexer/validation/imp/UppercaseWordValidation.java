package main.java.com.csg.word.indexer.validation.imp;

import main.java.com.csg.word.indexer.model.IndexedWord;
import main.java.com.csg.word.indexer.validation.IValidation;

import java.util.List;

public class UppercaseWordValidation implements IValidation {

    @Override
    public void validate(List<String> words, IndexedWord indexedWord) {
        long count = words.stream()
                .filter(w -> w != null && !w.isBlank() && Character.isUpperCase(w.charAt(0)))
                .count();

        indexedWord.setUppercaseWordCount(count);
    }
}
