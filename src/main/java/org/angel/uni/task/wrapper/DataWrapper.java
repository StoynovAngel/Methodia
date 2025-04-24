package org.angel.uni.task.wrapper;

import java.util.List;

public class DataWrapper {
    private List<String> strings;
    private List<String> emojis;
    private String words;

    public List<String> getStrings() {
        return strings;
    }

    public List<String> getEmojis() {
        return emojis;
    }

    public String getSentence() {
        return words;
    }
}
