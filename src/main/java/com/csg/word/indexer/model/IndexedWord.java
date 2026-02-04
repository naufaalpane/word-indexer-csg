package main.java.com.csg.word.indexer.model;

import java.util.Set;

public class IndexedWord {
    private long uppercaseWordCount;
    private Set<String> longWordSet;

    public long getUppercaseWordCount() {
        return uppercaseWordCount;
    }

    public void setUppercaseWordCount(long uppercaseWordCount) {
        this.uppercaseWordCount = uppercaseWordCount;
    }

    public Set<String> getLongWordSet() {
        return longWordSet;
    }

    public void setLongWordSet(Set<String> longWordSet) {
        this.longWordSet = longWordSet;
    }
}
