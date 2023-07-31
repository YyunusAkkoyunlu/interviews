package preperation.leetcode.problemsolving.easy;

/**

 https://leetcode.com/problems/length-of-last-word


 Given a string s consisting of words and spaces, return the length of the last word in the string.

 Example 1:
     Input: s = "Hello World"
     Output: 5
     Explanation: The last word is "World" with length 5.

 Example 2:
     Input: s = "   fly me   to   the moon  "
     Output: 4
     Explanation: The last word is "moon" with length 4.

 Example 3:
     Input: s = "luffy is still joyboy"
     Output: 6
     Explanation: The last word is "joyboy" with length 6.

 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String str) {
        int length = 0;
        for (int i = str.length() - 1; i >= 0 ; i--) {
            if (str.charAt(i) != ' ') {
                length++;
            } else {
                if (length > 0) {
                    return length;
                }
            }
        }

        return length;
    }

}
