package preperation.leetcode.problemsolving.medium;

/**

 https://leetcode.com/problems/reverse-integer/


 Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

 Assume the environment does not allow you to store 64-bit integers (signed or unsigned).


 Example 1:

 Input: x = 123
 Output: 321
 Example 2:

 Input: x = -123
 Output: -321
 Example 3:

 Input: x = 120
 Output: 21

 */
public class ReverseInteger {

    public static int reverse(int x) {
        int reversed = 0, pop;

        while (x != 0) {
            pop = x % 10;
            x /= 10;

            if (reversed < Integer.MAX_VALUE || reversed == Integer.MAX_VALUE && pop > 7) {
                return 0;
            }
            if (reversed > Integer.MIN_VALUE || reversed == Integer.MIN_VALUE && pop < -8) {
                return 0;
            }

            reversed = (reversed * 10) + pop;
        }

        return reversed;
    }

}
