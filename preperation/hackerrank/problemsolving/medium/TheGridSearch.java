package preperation.hackerrank.problemsolving.medium;

import java.util.List;

/**

 https://www.hackerrank.com/challenges/the-grid-search/

 Given an array of strings of digits, try to find the occurrence of a given pattern of digits. In the grid and pattern arrays, each string represents a row in the grid.

 For example, consider the following grid:
     1234567890
     0987654321
     1111111111
     1111111111
     2222222222

 The pattern array is:
     876543
     111111
     111111

 The pattern begins at the second row and the third column of the grid and continues in the following two rows. The pattern is said to be present in the grid.
 The return value should be YES or NO, depending on whether the pattern is found. In this case, return YES.

 */
public class TheGridSearch {

    public static String gridSearch(List<String> grid, List<String> pattern) {

        for (int i = 0; i < grid.size() - pattern.size() + 1; i++) {
            for (int j = 0; j < grid.get(0).length() - pattern.get(0).length() + 1; j++) {
                boolean flag = true;
                for (int x = 0; x < pattern.size(); x++) {
                    for (int y = 0; y < pattern.get(0).length(); y++) {
                        if (grid.get(i + x).charAt(j + y) != pattern.get(x).charAt(y)) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    return "YES";
                }
            }
        }

        return "NO";
    }

}
