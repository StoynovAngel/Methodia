package org.angel.uni.task.task2;

import org.angel.uni.task.mapper.GsonConverter;
import org.angel.uni.task.wrapper.DataWrapper;

import java.util.*;

public class WordCounter {

    private static final String REGEX_PATTERN = "[a-zA-Z.,!?]+";
    private static final String REGEX_SPLIT = "[\\s+]";
    private static final Map<String, Integer> wordCounterMap = new HashMap<>();;

    public static void wordCounterWithMap() {
        DataWrapper wrapper = GsonConverter.getContentFromJson();
        String sentence = wrapper.getWords();
        System.out.println(sentence);

        if (sentence == null) {
            System.out.println("Sentence cannot be null.");
            return;
        }

        List<String> words =  new ArrayList<>(Arrays.asList(sentence.split(REGEX_SPLIT)));
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            if (!word.matches(REGEX_PATTERN)) {
                iterator.remove();
            }
            if (wordCounterMap.containsKey(word)) {
                wordCounterMap.merge(word, 1, Integer::sum);
            } else {
                wordCounterMap.put(word, 1);
            }
        }

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCounterMap.entrySet());
        sortedEntries.sort((entry1, entry2) -> {
            int countCompare = entry2.getValue().compareTo(entry1.getValue());
            if (countCompare != 0) {
                return countCompare;
            } else {
                return entry1.getKey().compareTo(entry2.getKey());
            }
        });

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
