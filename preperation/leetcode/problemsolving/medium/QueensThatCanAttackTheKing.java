package preperation.leetcode.problemsolving.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    https://leetcode.com/problems/queens-that-can-attack-the-king/

    On a 0-indexed 8 x 8 chessboard, there can be multiple black queens and one white king.
    You are given a 2D integer array queens where queens[i] = [xQueeni, yQueeni] represents the position of the ith black queen on the chessboard. You are also given an integer array king of length 2 where king = [xKing, yKing] represents the position of the white king.
    Return the coordinates of the black queens that can directly attack the king. You may return the answer in any order.

    Example 1:
        Input: queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
        Output: [[0,1],[1,0],[3,3]]
        Explanation: The diagram above shows the three queens that can directly attack the king and the three queens that cannot attack the king (i.e., marked with red dashes).

    Example 2:
        Input: queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
        Output: [[2,2],[3,4],[4,4]]
        Explanation: The diagram above shows the three queens that can directly attack the king and the three queens that cannot attack the king (i.e., marked with red dashes).
 */
public class QueensThatCanAttackTheKing {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] seen = new boolean[8][8];

        for (int[] queen : queens) {
            seen[queen[0]][queen[1]] = true;
        }

        int[] directions = {-1, 0, 1};
        for (int dx : directions) {
            for (int dy : directions) {
                if (dx == 0 && dy == 0) {
                    continue;
                }

                int kingX = king[0];
                int kingY = king[1];

                while (kingX + dx >= 0 && kingX + dx < 8 && kingY + dy >= 0 && kingY + dy < 8) {
                    kingX += dx;
                    kingY += dy;

                    if (seen[kingX][kingY]) {
                        result.add(Arrays.asList(kingX, kingY));
                        break;
                    }
                }
            }
        }

        return result;
    }
}
