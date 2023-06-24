package preperation.leetcode.problemsolving.medium;

/**

 https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/


 Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

 If target is not found in the array, return [-1, -1].

 You must write an algorithm with O(log n) runtime complexity.

 Example 1:
     Input: nums = [5,7,7,8,8,10], target = 8
     Output: [3,4]

 Example 2:
     Input: nums = [5,7,7,8,8,10], target = 6
     Output: [-1,-1]

 Example 3:
     Input: nums = [], target = 0
     Output: [-1,-1]

 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        result[0] = findStartingIndex(nums, target);
        result[1] = findEndingIndex(nums, target);

        return result;
    }

    private static int findStartingIndex(int[] nums, int target) {
        int index = -1;

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int midpoint = start + (end - start) / 2;

            if (nums[midpoint] >= target) {
                end = midpoint - 1;
            } else {
                start = midpoint + 1;
            }

            if (nums[midpoint] == target) {
                index = midpoint;
            }
        }


        return index;
    }

    private static int findEndingIndex(int[] nums, int target) {
        int index = -1;

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int midpoint = start + (end - start) / 2;

            if (nums[midpoint] <= target) {
                start = midpoint + 1;
            } else {
                end = midpoint - 1;
            }

            if (nums[midpoint] == target) {
                index = midpoint;
            }
        }

        return index;
    }

}
