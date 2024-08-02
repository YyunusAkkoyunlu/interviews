package preperation.leetcode.problemsolving.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*

https://leetcode.com/problems/buddy-strings

Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].

For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

Example 1:
    Input: s = "ab", goal = "ba"
    Output: true
    Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.

Example 2:
    Input: s = "ab", goal = "ab"
    Output: false
    Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.

Example 3:
    Input: s = "aa", goal = "aa"
    Output: true
    Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.

 */
public class BuddyStrings {

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            HashSet<Character> uniqueCharacters = new HashSet<>();
            for (char ch : s.toCharArray()) {
                uniqueCharacters.add(ch);
            }

            return uniqueCharacters.size() < s.length();
        }

        List<Integer> differenceIndicies = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                differenceIndicies.add(i);
            }
        }

        return (differenceIndicies.size() == 2 && s.charAt(differenceIndicies.get(0)) == goal.charAt(differenceIndicies.get(1)) && s.charAt(differenceIndicies.get(1)) == goal.charAt(differenceIndicies.get(0)));
    }

}
