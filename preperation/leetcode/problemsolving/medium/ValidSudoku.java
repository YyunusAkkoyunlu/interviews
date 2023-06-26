package preperation.leetcode.problemsolving.medium;

import java.util.HashSet;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentChar = board[i][j];
                if (currentChar != '.') {
                    if (!seen.add("number" + " in row " + i) ||
                            !seen.add("number" + " in column " + j) ||
                            !seen.add("number" + " in block " + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
