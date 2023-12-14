package preperation.leetcode.problemsolving.easy;

/*
    https://leetcode.com/problems/monotonic-array

    An array is monotonic if it is either monotone increasing or monotone decreasing.
    An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
    Given an integer array nums, return true if the given array is monotonic, or false otherwise.

    Example 1:
        Input: nums = [1,2,2,3]
        Output: true

    Example 2:
        Input: nums = [6,5,4,4]
        Output: true

    Example 3:
        Input: nums = [1,3,2]
        Output: false

 */
public class MonoticArray {

    public static boolean isMonotic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                increasing = false;
            }
            if (A[i] < A[i + 1]) {
                decreasing =  false;
            }
        }

        return increasing || decreasing;
    }

}
