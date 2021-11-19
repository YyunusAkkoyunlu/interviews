package preperation.crackingTheCodingInterview.chapterOneArraysAndStrings;

import java.util.Arrays;
/*
    Given two strings, write a method to decide if one is a permutation of the other
*/
public class Permutation {

    String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);

        return new String(content);
    }

    boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        return sort(s).equals(sort(t));
    }

}
