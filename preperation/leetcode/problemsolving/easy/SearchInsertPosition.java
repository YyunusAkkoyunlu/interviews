package preperation.leetcode.problemsolving.easy;

/**

 https://leetcode.com/problems/search-insert-position/


 Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You must write an algorithm with O(log n) runtime complexity.

 Example 1:
     Input: nums = [1,3,5,6], target = 5
     Output: 2

 Example 2:
     Input: nums = [1,3,5,6], target = 2
     Output: 1

 Example 3:
     Input: nums = [1,3,5,6], target = 7
     Output: 4

 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex < endIndex) {
            int middle = startIndex + (endIndex - startIndex) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                endIndex = middle;
            } else {
                startIndex = middle + 1;
            }
        }

        return nums[startIndex] < target ? startIndex + 1 : startIndex;
    }

}
