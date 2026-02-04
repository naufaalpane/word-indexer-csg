package test.java.com.csg.word.indexer.validation;

import main.java.com.csg.word.indexer.model.IndexedWord;
import main.java.com.csg.word.indexer.validation.imp.UppercaseWordValidation;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UppercaseWordValidationTest {

    @Test
    public void countsWordsStartingWithUppercase() {
        List<String> words = List.of("Hello", "world", "Java", "code");

        IndexedWord indexedWord = new IndexedWord();
        new UppercaseWordValidation().validate(words, indexedWord);

        assertEquals(2, indexedWord.getUppercaseWordCount());
    }
}
