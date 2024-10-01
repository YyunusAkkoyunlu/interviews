package preperation.leetcode.problemsolving.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*

    https://leetcode.com/problems/longest-increasing-subsequence/

    Given an integer array nums, return the length of the longest strictly increasing subsequence.

    Example 1:
        Input: nums = [10,9,2,5,3,7,101,18]
        Output: 4
        Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

    Example 2:
        Input: nums = [0,1,0,3,2,3]
        Output: 4

    Example 3:
        Input: nums = [7,7,7,7,7,7,7]
        Output: 1

 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] numbers) {
        List<Integer> subSequence = new ArrayList<>();

        for (int number : numbers) {
            if (subSequence.isEmpty() || subSequence.get(subSequence.size() - 1) < number) {
                subSequence.add(number);
            } else {
                int indexOfTheCurrentNumber = Collections.binarySearch(subSequence, number);
                if (indexOfTheCurrentNumber < 0) {
                    indexOfTheCurrentNumber = -(indexOfTheCurrentNumber + 1);
                }
                subSequence.set(indexOfTheCurrentNumber, number);
            }
        }

        return subSequence.size();
    }

}
