package matrix;

public class SearchA2DMatrix {
    //Problem statement - https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
    public static void main(String[] args) {
        int matrix[][] = {{ 10, 20, 30, 40 },
                        { 15, 25, 35, 45 },
                        { 27, 29, 37, 48 },
                        { 32, 33, 39, 50 }};
        if(!findNum(matrix, 28))
            System.out.println("Target not found in matrix!");
    }

    private static boolean findNum(int[][] matrix, int target) {
        int row = 0, col = matrix.length - 1;
        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == target) {
                System.out.println("Target found at position " + row + ", " + col);
                return true;
            }
            else if(matrix[row][col] <  target)
                row++;
            else
                col--;
        }
        return false;
    }
}
