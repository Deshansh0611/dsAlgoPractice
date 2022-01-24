package matrix;

public class SpiralTraversal {
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        int row = 4, col = 4;
        printMatrixInSpiralForm(matrix, row, col);
    }

    private static void printMatrixInSpiralForm(int[][] matrix, int row, int col) {
        int dir = 0;
        int left = 0, right = col - 1;
        int up = 0, down = row - 1;
        while(left <= right && up <= down) {
            if (dir == 0) {
                for (int i = left; i <= right; i++)
                    System.out.print(matrix[up][i] + " ");
                dir++;
                up++;
            }
            if (dir == 1) {
                for (int i = up; i <= down; i++)
                    System.out.print(matrix[i][right] + " ");
                dir++;
                right--;
            }
            if (dir == 2) {
                for (int i = right; i >= left; i--)
                    System.out.print(matrix[down][i] + " ");
                dir++;
                down--;
            }
            if (dir == 3) {
                for (int i = down; i >= up; i--)
                    System.out.print(matrix[i][left] + " ");
                dir++;
                left++;
            }
            dir = dir % 4;
        }
    }
}
