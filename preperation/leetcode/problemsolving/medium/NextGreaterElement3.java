package preperation.leetcode.problemsolving.medium;

import java.util.Arrays;

/*
    https://leetcode.com/problems/next-greater-element-iii

    Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

    Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

    Example 1:
        Input: n = 12
        Output: 21

    Example 2:
        Input: n = 21
        Output: -1
 */
public class NextGreaterElement3 {

    public static int nextGreaterElement(int number) {
        char[] numberArray = (number + "").toCharArray();
        int i, j;

        for (i = numberArray.length - 1; i > 0; i--) {
            if (numberArray[i] > numberArray[i - 1]) {
                break;
            }
        }
        if (i == 0) {
            return -1;
        }

        int firstSmallNumber = numberArray[i - 1], smallestIndex = i;
        for (j = i + 1; j < numberArray.length; j++) {
            if (numberArray[j] > firstSmallNumber && numberArray[smallestIndex] >= numberArray[j]) {
                smallestIndex = j;
            }
        }

        char temp = numberArray[i - 1];
        numberArray[i - 1] = numberArray[smallestIndex];
        numberArray[smallestIndex] = temp;

        Arrays.sort(numberArray, i, numberArray.length);

        long value = Long.parseLong(new String(numberArray));

        return value <= Integer.MAX_VALUE ? (int) value : -1;
    }

}
