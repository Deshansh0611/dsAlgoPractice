package matrix;

public class SudokuSolver {
    private static int GRID_SIZE = 9;
    public static void main(String[] args) {
        int[][] board = {
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };
        solveBoard(board);
        printBoard(board);
    }

    private static boolean solveBoard(int[][] board) {
        for(int row = 0; row<GRID_SIZE; row++) {
            for(int column = 0; column<GRID_SIZE; column++) {
                if(board[row][column] == 0) {
                    for(int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if(isValidPlacement(board, row, column, numberToTry)) {
                            board[row][column] = numberToTry;
                            if(solveBoard(board))
                                return true;
                            else
                                board[row][column] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isNumberInRow(int[][] board, int row, int number) {
        for(int i = 0; i<GRID_SIZE; i++) {
            if(board[row][i] == number)
                return true;
        }
        return false;
    }

    private static boolean isNumberInColumn(int[][] board, int column, int number) {
        for(int i = 0; i<GRID_SIZE; i++) {
            if(board[i][column] == number)
                return true;
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int row, int column, int number) {
        int baseRowInBox = row - row%3;
        int baseColumnInBox = column - column%3;
        for(int i = baseRowInBox; i<baseRowInBox + 3; i++) {
            for(int j = baseColumnInBox; j<baseColumnInBox + 3; j++) {
                if(board[i][j] == number)
                    return true;
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] board, int row, int column, int number) {
        return !isNumberInRow(board, row, number)
        && !isNumberInColumn(board, column, number)
        && !isNumberInBox(board, row, column, number);
    }

    private static void printBoard(int[][] board) {
        for(int row = 0; row<GRID_SIZE; row++) {
            if(row!=0 && row%3 == 0)
                System.out.println("-----------");
            for(int column = 0; column<GRID_SIZE; column++) {
                if(column!=0 && column%3 == 0)
                    System.out.print("|");
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }
}