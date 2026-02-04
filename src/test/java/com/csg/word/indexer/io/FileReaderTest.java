package test.java.com.csg.word.indexer.io;

import main.java.com.csg.word.indexer.io.FileReader;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    @Test
    public void readsWordsFromFile() throws Exception {
        Path tempFile = Files.createTempFile("words", ".txt");
        Files.writeString(tempFile, "Foo bar baz foobar");

        FileReader fileReader = new FileReader();
        List<String> words = fileReader.readWordsFromFile(tempFile.toString());

        assertEquals(List.of("Foo", "bar", "baz", "foobar"), words);
    }
}
