package org.angel.uni.task.task4;

import org.angel.uni.task.mapper.GsonConverter;
import org.angel.uni.task.wrapper.DataWrapper;

import java.util.HashMap;
import java.util.Map;

public class Duplicate {

    private static final int SPACE_ASCII_CODE = 32;
    private static final DataWrapper dataWrapper = GsonConverter.getContentFromJson();
    private static final String EXAMPLE = dataWrapper.getWords();

    public static void findDuplicateCharacters() {
        if (EXAMPLE == null) {
            System.out.println("Input is null.");
            return;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int codePoint : EXAMPLE.codePoints().toArray()) {
            frequencyMap.put(codePoint, frequencyMap.getOrDefault(codePoint, 0) + 1);
        }

        System.out.println("Duplicate characters:");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getKey() != SPACE_ASCII_CODE && entry.getValue() > 1) {
                String character = new String(Character.toChars(entry.getKey()));
                System.out.println("'" + character + "' -> " + entry.getValue() + " times");
            }
        }
    }
}
