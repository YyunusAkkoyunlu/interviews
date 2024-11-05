package preperation.leetcode.problemsolving.hard;

import java.util.Stack;

/*

    Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
    Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

    Example 1:
        Input: s = "1 + 1"
        Output: 2

    Example 2:
        Input: s = " 2-1 + 2 "
        Output: 3

    Example 3:
        Input: s = "(1+(4+5+2)-3)+(6+8)"
        Output: 23

    Constraints:
        1 <= s.length <= 3 * 105
        s consists of digits, '+', '-', '(', ')', and ' '.
        s represents a valid expression.
        '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
        '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
        There will be no two consecutive operators in the input.
        Every number and running calculation will fit in a signed 32-bit integer.

 */
public class BasicCalculator {

    public static int calculate2(String str) {
        Stack<Integer> stack = new Stack<>();
        int lastDigit  = 0;
        int sign = 1;
        int result = 0;

        stack.push(sign);
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (Character.isDigit(currentChar)) {
                lastDigit = lastDigit * 10 + currentChar - '0';
            } else if (currentChar == '+' || currentChar == '-') {
                result += lastDigit * sign;
                sign = stack.peek() * (currentChar == '+' ? 1 : -1);
                lastDigit = 0;
            } else if (currentChar == '(') {
                stack.push(sign);
            } else if (currentChar == ')') {
                stack.pop();
            }
        }

        result += sign * lastDigit;
        return result;
    }

}
