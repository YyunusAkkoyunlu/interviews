package preperation.leetcode.problemsolving.medium;

import java.util.ArrayList;
import java.util.List;

/*

    https://leetcode.com/problems/ugly-number-ii/

    An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
    Given an integer n, return the nth ugly number.

    Example 1:
        Input: n = 10
        Output: 12
        Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

    Example 2:
        Input: n = 1
        Output: 1
        Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.

 */
public class UglyNumberII {

    public int nthUglyNumber(int number) {
        if (number == 0) {
            return 0;
        }

        int counterOf2 = 0, counterOf3 = 0, counterOf5 = 0;

        List<Integer> table = new ArrayList<>();
        table.add(1);
        while (table.size() < number) {
            int nextValue = Math.min(table.get(counterOf2) * 2, Math.min(table.get(counterOf3) * 3, table.get(counterOf5) * 5));
            table.add(nextValue);

            if (table.get(counterOf2) * 2 == nextValue) {
                counterOf2++;
            }
            if (table.get(counterOf3) * 3 == nextValue) {
                counterOf3++;
            }
            if (table.get(counterOf5) * 5 == nextValue) {
                counterOf5++;
            }
        }

        return table.get(table.size() - 1);
    }

}
