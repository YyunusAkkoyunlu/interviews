package preperation.crackingTheCodingInterview.chapterOneArraysAndStrings;

public class OneAway {

    private static boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {

        }

        return false;
    }

    private static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0, index2 = 0;

        while (s1.length() > index1 && s2.length() > index2) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2 ++;
            } else {
                index1++;
                index2++;
            }
        }

        return true;
    }

    private static boolean oneEditReplace(String first, String second) {
        boolean foundDifference = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

}
