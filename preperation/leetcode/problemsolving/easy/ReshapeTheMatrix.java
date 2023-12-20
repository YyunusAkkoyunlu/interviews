package preperation.leetcode.problemsolving.easy;

public class ReshapeTheMatrix {

    public static int[][] matrixReshapeV1(int[][] matrix, int r, int c) {
        int matrixRowLength = matrix.length;
        int matrixColumnLength = matrix[0].length;

        if (matrixRowLength * matrixColumnLength != r * c) {
            return matrix;
        }

        int[][] result = new int[r][c];

        int row = 0;
        int column = 0;

        for (int i = 0; i < matrixRowLength; i++) {
            for (int j = 0; j < matrixColumnLength; j++) {
                result[row][column] = matrix[i][j];
                column++;
                if (column == c) {
                    column = 0;
                    row++;
                }
            }
        }

        return result;
    }

    public static int[][] matrixReshapeV2(int[][] matrix, int r, int c) {
        int matrixRowLength = matrix.length;
        int matrixColumnLength = matrix[0].length;

        if (matrixRowLength * matrixColumnLength != r * c) {
            return matrix;
        }

        int[][] result = new int[r][c];

        for (int i = 0; i < r * c; i++) {
            result[i / c][i % c] = matrix[i / matrixColumnLength][i % matrixColumnLength];
        }

        return result;
    }

}
