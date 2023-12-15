package preperation.leetcode.problemsolving.easy;

/*

    https://leetcode.com/problems/is-subsequence/

    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

    Example 1:
        Input: s = "abc", t = "ahbgdc"
        Output: true

    Example 2:
        Input: s = "axc", t = "ahbgdc"
        Output: false

 */
public class IsSubsequence {

    public static boolean isSubsequence(String smalller, String longer) {
        if (smalller.length() == 0) {
            return true;
        }

        int smallerPointer = 0;
        int longerPointer = 0;

        while (longer.length() > longerPointer) {
            if (longer.charAt(longerPointer) == smalller.charAt(smallerPointer)) {
                smallerPointer++;

                if (smallerPointer == smalller.length()) {
                    return true;
                }
            }
            longerPointer++;
        }

        return false;
    }

}
