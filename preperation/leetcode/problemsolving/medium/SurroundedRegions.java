package preperation.leetcode.problemsolving.medium;

/**
 https://leetcode.com/problems/surrounded-regions/

 Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 Example 1:
     Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
     Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
     Explanation: Notice that an 'O' should not be flipped if:
     - It is on the border, or
     - It is adjacent to an 'O' that should not be flipped.
     The bottom 'O' is on the border, so it is not flipped.
     The other three 'O' form a surrounded region, so they are flipped.

 Example 2:
     Input: board = [["X"]]
     Output: [["X"]]
 */
public class SurroundedRegions {

    public static void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int colums = board[0].length;

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                boundaryDFS(board, i, 0);
            }
            if (board[i][colums - 1] == 'O') {
                boundaryDFS(board, i, colums - 1);
            }
        }

        for (int i = 0; i < colums; i++) {
            if (board[0][i] == 'O') {
                boundaryDFS(board,0, i);
            }
            if (board[rows - 1][i] == 'O') {
                boundaryDFS(board, rows - 1, i);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static  void boundaryDFS(char[][] board, int row, int column) {
        if ((row > board.length || row < 0) || (column > board[0].length || column < 0)) {
            return;
        }

        if (board[row][column] == 'O') {
            board[row][column] = '*';
        }

        if (row > 0 && board[row - 1][column] == 'O') { // up
            boundaryDFS(board, row - 1, column);
        }
        if (row < board.length - 1 && board[row + 1][column] == 'O') { // down
            boundaryDFS(board, row + 1, column);
        }
        if (column > 0 && board[row][column - 1] == 'O') { // left
            boundaryDFS(board, row, column - 1);
        }
        if (column < board[0].length - 1 && board[row][column + 1] == 'O') { // right
            boundaryDFS(board, row, column + 1);
        }
    }

}
