package test.java.com.csg.word.indexer.validation;

import main.java.com.csg.word.indexer.model.IndexedWord;
import main.java.com.csg.word.indexer.validation.imp.LongWordValidation;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LongWordValidationTest {

    @Test
    public void collectsWordsLongerThanFiveCharacters() {
        List<String> words = List.of("short", "longword", "anotherlong");

        IndexedWord indexedWord = new IndexedWord();
        new LongWordValidation().validate(words, indexedWord);

        assertEquals(List.of("foobar", "quuqux"), indexedWord.getLongWordSet());
    }
}
