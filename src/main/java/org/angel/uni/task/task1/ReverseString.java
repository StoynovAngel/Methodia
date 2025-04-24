package org.angel.uni.task.task1;

public class ReverseString {

    public static String reverseString(String string) {
        if (string == null || string.isEmpty()) {
            return "nothing";
        }

        char[] chars = string.toCharArray();
        String reversed = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed += chars[i];
        }
        return reversed;
    }
}
