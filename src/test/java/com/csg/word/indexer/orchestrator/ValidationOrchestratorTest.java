package test.java.com.csg.word.indexer.orchestrator;

import main.java.com.csg.word.indexer.model.IndexedWord;
import main.java.com.csg.word.indexer.orchestrator.ValidationOrchestrator;
import main.java.com.csg.word.indexer.validation.IValidation;
import main.java.com.csg.word.indexer.validation.imp.LongWordValidation;
import main.java.com.csg.word.indexer.validation.imp.UppercaseWordValidation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ValidationOrchestratorTest {

    @Test
    public void appliesAllRules() {
        List<String> words = List.of("Foo", "bar", "baz", "foobar");

        List<IValidation> validations = new ArrayList<>();
        validations.add(new UppercaseWordValidation());
        validations.add(new LongWordValidation());

        ValidationOrchestrator validationOrchestrator = new ValidationOrchestrator(validations);
        IndexedWord indexedWord = validationOrchestrator.run(words);

        assertEquals(1, indexedWord.getUppercaseWordCount());
        assertEquals(List.of("Foo"), indexedWord.getLongWordSet());
    }

}
