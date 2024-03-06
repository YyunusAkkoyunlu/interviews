package preperation.leetcode.problemsolving.medium;

import java.util.ArrayList;
import java.util.List;

/*
    https://leetcode.com/problems/partition-labels

    You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

    Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

    Return a list of integers representing the size of these parts.

    Example 1:
        Input: s = "ababcbacadefegdehijhklij"
        Output: [9,7,8]
        Explanation:
            The partition is "ababcbaca", "defegde", "hijhklij".
            This is a partition so that each letter appears in at most one part.
            A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

    Example 2:
        Input: s = "eccbbbbdec"
        Output: [10]
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        List<Integer> outputArray = new ArrayList<>();
        int[] lastIndicies = new int[26];

        for (int i = 0; i < str.length(); i++) {
            lastIndicies[str.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;

        for (int i = 0; i < str.length(); i++) {
            end = Math.max(end, lastIndicies[str.charAt(i) - 'a']);
            if (i == end) {
                outputArray.add(end - start + 1);
                start = end + 1;
            }
        }

        return outputArray;
    }

}
