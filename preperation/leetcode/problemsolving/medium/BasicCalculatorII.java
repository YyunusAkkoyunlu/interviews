package preperation.leetcode.problemsolving.medium;

import java.util.Stack;

/*

    https://leetcode.com/problems/basic-calculator-ii

    Given a string s which represents an expression, evaluate this expression and return its value.
    The integer division should truncate toward zero.
    You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
    Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

    Example 1:
        Input: s = "3+2*2"
        Output: 7

    Example 2:
        Input: s = " 3/2 "
        Output: 1

    Example 3:
        Input: s = " 3+5 / 2 "
        Output: 5

 */
public class BasicCalculatorII {

    public static int calculate(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char sign = '+';

        int strLength = str.length();
        for (int i = 0; i < strLength; i++) {
            char currentCharacter = str.charAt(i);
            if (Character.isDigit(currentCharacter)) {
                currentNumber = currentNumber * 10 + currentCharacter - '0';
            }
            if (!Character.isDigit(currentCharacter) && currentCharacter != ' ' || i == strLength - 1) {
                if (sign == '+') {
                    stack.push(currentNumber);
                }
                else if (sign == '-') {
                    stack.push(-currentNumber);
                }
                else if (sign == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                else if (sign == '/') {
                    stack.push(stack.pop() / currentNumber);
                }

                sign = currentCharacter;
                currentNumber = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

}
