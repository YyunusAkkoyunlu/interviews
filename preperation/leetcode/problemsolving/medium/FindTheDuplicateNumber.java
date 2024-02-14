package preperation.leetcode.problemsolving.medium;

import java.util.HashSet;
import java.util.Set;

/*
    https://leetcode.com/problems/find-the-duplicate-number

    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
    There is only one repeated number in nums, return this repeated number.
    You must solve the problem without modifying the array nums and uses only constant extra space.

    Example 1:
        Input: nums = [1,3,4,2,2]
        Output: 2

    Example 2:
        Input: nums = [3,1,3,4,2]
        Output: 3
 */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        System.out.println(findTheDuplicateNumber.findDuplicateV2(new int[]{2, 6, 4, 1, 3, 5}));
    }

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public int findDuplicateV2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int length = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }

        return length;
    }

}
