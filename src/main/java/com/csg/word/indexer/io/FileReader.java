package main.java.com.csg.word.indexer.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    private static final String REGEX_NON_WORD = "\\W+";
    private static final String EXTENSION_TXT = ".txt";

    private void fileValidation(Path path, String fileName) {
        if (!Files.exists(path)) {
            throw new IllegalArgumentException("File does not exist: " + fileName);
        }

        if (!Files.isRegularFile(path)) {
            throw new IllegalArgumentException("Not a regular file: " + fileName);
        }

        if (!fileName.toLowerCase().endsWith(EXTENSION_TXT)) {
            throw new IllegalArgumentException("Invalid file type (only .txt allowed): " + fileName);
        }

    }

    public List<String> readWordsFromFile(String fileName) {
        Path path = Path.of(fileName);
        fileValidation(path, fileName);

        try (Stream<String> lines = Files.lines(path)) {
            return lines
                    .flatMap(line -> Arrays.stream(line.split(REGEX_NON_WORD)))
                    .filter(word -> !word.isBlank())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + fileName, e);
        }

    }
}
