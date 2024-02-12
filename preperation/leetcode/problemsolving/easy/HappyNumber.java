package preperation.leetcode.problemsolving.easy;

/**
    https://leetcode.com/problems/happy-number/description/

    Write an algorithm to determine if a number n is happy.

    A happy number is a number defined by the following process:
        Starting with any positive integer, replace the number by the sum of the squares of its digits.
        Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
        Those numbers for which this process ends in 1 are happy.
        Return true if n is a happy number, and false if not.

    Example 1:
        Input: n = 19
        Output: true
    Explanation:
        12 + 92 = 82
        82 + 22 = 68
        62 + 82 = 100
        12 + 02 + 02 = 1

    Example 2:
        Input: n = 2
        Output: false
 */
public class HappyNumber {

    public int digitSquareSum(int number) {
        int sum = 0;
        while (number > 0) {
            int remainder = number % 10;
            sum += remainder * remainder;
            number /= 10;
        }

        return sum;
    }

    public boolean isHappy(int number) {
        int slow = number;
        int fast = number;

        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(digitSquareSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

}
