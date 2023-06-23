package preperation.leetcode.problemsolving.medium;

/**

 https://leetcode.com/problems/zigzag-conversion/


 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string s, int numRows);


 Example 1:

 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"
 Example 2:

 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"
 Explanation:
 P     I    N
 A   L S  I G
 Y A   H R
 P     I
 Example 3:

 Input: s = "A", numRows = 1
 Output: "A"


 Constraints:

 1 <= s.length <= 1000
 s consists of English letters (lower-case and upper-case), ',' and '.'.
 1 <= numRows <= 1000

 */
public class ZigzagConversion {

    public static String convert(String str, int numRows) {
        if (numRows == 1) {
            return str;
        }

        StringBuilder[] stringBuilder = new StringBuilder[numRows];
        int currentRow = 0, direction = 0;

        for (int i = 0; i < stringBuilder.length; i++) {
            stringBuilder[i] = new StringBuilder();
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            currentRow += direction;
            stringBuilder[currentRow].append(c);

            if (currentRow == 0 || currentRow == numRows - 1) {
                direction = (direction == 0) ? 1 : -direction;
            }
        }

        String result = "";
        for (StringBuilder sb : stringBuilder) {
            result += sb.toString();
        }

        return result;
    }

}
