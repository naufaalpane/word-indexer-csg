package main.java.com.csg.word.indexer.validation;

import main.java.com.csg.word.indexer.model.IndexedWord;

import java.util.List;

public class ValidationOrchestrator {
    private final List<IValidation> rules;

    public ValidationOrchestrator(List<IValidation> rules) {
        this.rules = rules;
    }

    public IndexedWord run(List<String> words) {
        IndexedWord indexedWord = new IndexedWord();
        for (IValidation rule : rules) {
            rule.validate(words, indexedWord);
        }
        return indexedWord;
    }

}
