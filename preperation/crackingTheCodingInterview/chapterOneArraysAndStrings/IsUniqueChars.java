package preperation.crackingTheCodingInterview.chapterOneArraysAndStrings;

/*
    Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
* */

public class IsUniqueChars {

    boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i);
            if (charSet[value]) { // if that char added before
                return false;
            }
            charSet[value] = true;
        }

        return true;
    }

    boolean isUniqueCharsV2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i) - 'a';
            if ((checker & (1 << value)) > 0) {
                return false;
            }
            checker |= (1 << value);
        }

        return true;
    }

}
