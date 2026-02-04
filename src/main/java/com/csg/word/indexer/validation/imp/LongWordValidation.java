package main.java.com.csg.word.indexer.validation.imp;

import main.java.com.csg.word.indexer.model.IndexedWord;
import main.java.com.csg.word.indexer.validation.IValidation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LongWordValidation implements IValidation {

    @Override
    public void validate(List<String> words, IndexedWord indexedWord) {
        Set<String> longWords = words.stream()
                .filter(w -> w.length() > 5)
                .collect(Collectors.toSet());

        indexedWord.setLongWordSet(longWords);
    }
}
