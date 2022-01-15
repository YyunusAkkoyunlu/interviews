package preperation.hackerrank.problemsolving.medium;

import java.math.BigInteger;

/**

 https://www.hackerrank.com/challenges/extra-long-factorials

 The factorial of the integer n, written n!, is defined as:
    n! = n * (n-1) * (n-2) * ........ * 3 * 2 * 1
 Calculate and print the factorial of a given integer.

 For example, if n = 30, we calculate 30 * 29 * 28 * ...... * 3 * 2 * 1 and get 265252859812191058636308480000000.

 Function Description
    Complete the extraLongFactorials function in the editor below. It should print the result and return.

    extraLongFactorials has the following parameter(s):
        n: an integer

 Note: Factorials of  can't be stored even in a  long long variable. Big integers must be used for such calculations. Languages like Java, Python, Ruby etc. can handle big integers, but we need to write additional code in C/C++ to handle huge values.
 We recommend solving this challenge using BigIntegers.

 Input Format
    Input consists of a single integer n

 Constraints
    1 <= n <= 100

 Output Format
    Print the factorial of n.

 Sample Input
    25

 Sample Output
    15511210045550985984000000

 Explanation
    25! = 25 x 24 x 24 x ... x 3 x 2 x 1

 */
public class ExtraLongFactorials {

    public static void extraLongFactorials(int n) {
        BigInteger factorial = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(factorial);
    }

}
