package org.angel.uni.task.task1;

import org.angel.uni.task.mapper.GsonConverter;
import org.angel.uni.task.wrapper.DataWrapper;

public class ReverseString {

    private static final DataWrapper dataWrapper = GsonConverter.getContentFromJson();
    private static final String EXAMPLE = dataWrapper.getWords();

    public static void reverseString() {
        if (EXAMPLE == null || EXAMPLE.isEmpty()) {
            return;
        }

        String reversed = "";
        int[] codePoints = EXAMPLE.codePoints().toArray();
        for (int i = codePoints.length - 1; i >= 0; i--) {
            reversed += new String(Character.toChars(codePoints[i]));
        }
        System.out.println(EXAMPLE);
        System.out.println(reversed);
    }
}
