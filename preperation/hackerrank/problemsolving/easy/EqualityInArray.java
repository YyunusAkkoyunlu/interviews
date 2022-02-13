package preperation.hackerrank.problemsolving.easy;

import java.util.*;

/**

 https://www.hackerrank.com/challenges/equality-in-a-array

 Given an array of integers, determine the minimum number of elements to delete to leave only elements of equal value.

 Example
    Arr = [1,2,2,3]

 Delete the 2 elements 1 and 3 leaving arr=[2,2]. If both twos plus either the 1 or 3  are deleted, it takes 3 deletions to leave either [3] or [1]. The minimum number of deletions is 2.

 Function Description
    Complete the equalizeArray function in the editor below.

     equalizeArray has the following parameter(s):
     int arr[n]: an array of integers

 Returns
    int: the minimum number of deletions required

 Input Format
    The first line contains an integer , the number of elements in arr.
    The next line contains  space-separated integers arr[i].

 Constraints
     1<=n<=100
     1<=arr[i]<=100

 Sample Input
     STDIN       Function
     -----       --------
     5           arr[] size n = 5
     3 3 2 1 3   arr = [3, 3, 2, 1, 3]

 Sample Output
    2
 */
public class EqualityInArray {

    public static void main(String[] args) {
        System.out.println(equalizeArray(Arrays.asList(3, 3, 2, 1, 3)));
    }

    public static int equalizeArray(List<Integer> arr) {
        int max = 1;

        Map<Integer, Integer> nums = new HashMap<>();
        for (int number : arr) {
            if (!nums.containsKey(number)) {
                nums.put(number, 1);
            } else {
                nums.put(number, nums.get(number) + 1);
                if (nums.get(number) > max) {
                    max = nums.get(number);
                }
            }
        }

        return arr.size() - max;
    }

}
