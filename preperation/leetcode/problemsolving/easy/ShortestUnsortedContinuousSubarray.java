package preperation.leetcode.problemsolving.easy;

import java.util.Arrays;

/*
    https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

    Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.

    Return the shortest such subarray and output its length.

    Example 1:
        Input: nums = [2,6,4,8,10,9,15]
        Output: 5
        Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

    Example 2:
        Input: nums = [1,2,3,4]
        Output: 0

    Example 3:
        Input: nums = [1]
        Output: 0
 */
public class ShortestUnsortedContinuousSubarray {

    public static int findUnsortedSubarray(int[] nums) {
        int[] copyOfNums = nums.clone();
        Arrays.sort(copyOfNums);

        int start = nums.length;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copyOfNums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }

        return (end - start >= 0 ? end - start + 1 : 0);
    }

}
