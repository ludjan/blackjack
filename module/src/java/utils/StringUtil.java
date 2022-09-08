package module.src.java.utils;
public class StringUtil {
    
    public static boolean endsWithSubstring(String fullString, String expectedEnding) {
        int endingLen = expectedEnding.length();
        if (endingLen > fullString.length()) return false;
        String actualEnding = fullString.substring(fullString.length()-endingLen, fullString.length());
        return expectedEnding.equals(actualEnding);
    }

    public static boolean contains(String [] array, String element) {
        for (String s: array) {
            if (s.equals(element)) return true;
        }
        return false;
    }
}
