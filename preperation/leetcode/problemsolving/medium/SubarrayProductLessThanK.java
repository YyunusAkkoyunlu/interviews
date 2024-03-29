package preperation.leetcode.problemsolving.medium;

/*
    https://leetcode.com/problems/subarray-product-less-than-k/

    Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

    Example 1:
        Input: nums = [10,5,2,6], k = 100
        Output: 8
        Explanation: The 8 subarrays that have product less than 100 are:
        [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
        Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

    Example 2:
        Input: nums = [1,2,3], k = 0
        Output: 0
 */
public class SubarrayProductLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;

        if (k <= 1) {
            return result;
        }

        int product = 1;
        int leftPointer = 0, rightPointer = 0;

        while (rightPointer < nums.length) {
            product *= nums[rightPointer];
            while (product >= k) {
                product /= nums[leftPointer];
                leftPointer++;
            }

            result += rightPointer - leftPointer + 1;
            rightPointer++;
        }

        return result;
    }

}
