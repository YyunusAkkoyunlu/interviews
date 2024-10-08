package preperation.leetcode.problemsolving.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

    https://leetcode.com/problems/top-k-frequent-elements

    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

        Example 1:
            Input: nums = [1,1,1,2,2,3], k = 2
            Output: [1,2]
        Example 2:
            Input: nums = [1], k = 1
            Output: [1]

 */
public class TopKFrequentElements {

    public static List<Integer> topKFrequent(int[] numsbers, int k) {
        List<Integer>[] frequencyTable = new List[numsbers.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int number : numsbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (frequencyTable[frequency] == null) {
                frequencyTable[frequency] = new ArrayList<>();
            }
            frequencyTable[frequency].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for (int position = frequencyTable.length - 1; position >= 0 && result.size() < k; position--) {
            if (frequencyTable[position] != null) {
                result.addAll(frequencyTable[position]);
            }
        }

        return result;
    }

}
