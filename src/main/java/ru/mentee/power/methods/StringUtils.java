package ru.mentee.power.methods;

import com.sun.source.tree.BreakTree;

public class StringUtils {
    public static int countChars(String str, char target) {
        if (str == null || str.isEmpty()) return 0;

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) count++;
        }
        return count;
    }

    public static String truncate(String str, int maxLength) {
        if (str == null || str.isEmpty()) return "";
        if (str.length() <= maxLength) return str;
        return str.substring(0, maxLength) + "...";
    }

    public static boolean isPalindrome(String str) {
        if (str == null) return false;

        String cleaned = str.replaceAll("[^\\p{L}]", "").toLowerCase();

        if (cleaned.isEmpty()) {
            return false;
        }

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static String normalizeSpaces(String str) {
        if (str == null) return "";
        String trimmed = str.trim();
        return trimmed.replaceAll("\\s+", " ");
    }

    public static String join(String[] strings, String delimiter) {
        if (strings == null || strings.length == 0) return "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != null) {
                if (result.length() > 0) {
                    result.append(delimiter);
                }
                result.append(strings[i]);
            }
        }
        return result.toString();
    }
}