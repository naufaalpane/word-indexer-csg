package main.java.com.csg.word.indexer.validation;

import main.java.com.csg.word.indexer.model.IndexedWord;

import java.util.List;

public interface IValidation {
    void validate(List<String> words, IndexedWord indexedWord);
}
