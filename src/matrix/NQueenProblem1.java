package matrix;

import java.util.Arrays;
import java.util.stream.Stream;

public class NQueenProblem1 {
    //Problem statement - https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
    //In this problem, we are print only one possible solution of n queen problem
    public static void main(String[] args) {
        int boardSize = 4;
        int[][] board = new int[boardSize][boardSize]; //1 symbolises queen placement and 0 symbolises empty cell
        solveNQueen(board, 0);
    }

    private static boolean solveNQueen(int[][] board, int row) {
        if(row == board.length) {
            printBoard(board);
            return true;
        }
        for(int col = 0; col<board[row].length; col++) {
            if(isSafePlacement(board, row, col)) {
                board[row][col] = 1;
                if(solveNQueen(board, row+1))
                    return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    private static void printBoard(int[][] board) {
        Stream.of(board).map(Arrays::toString).forEach(System.out::println);
    }

    private static boolean isSafePlacement(int[][] board, int row, int col) {
        if(isSafeInRow(board, row, col) && isSafeInCol(board, row, col) && isSafeInDiagonal(board, row, col))
            return true;
        return false;
    }

    private static boolean isSafeInRow(int[][] board, int row, int col) {
        for(int i = 0; i<board.length; i++) {
            if(board[row][i] == 1)
                return false;
        }
        return true;
    }

    private static boolean isSafeInCol(int[][] board, int row, int col) {
        for(int i = 0; i<board.length; i++) {
            if(board[i][col] == 1)
                return false;
        }
        return true;
    }

    private static boolean isSafeInDiagonal(int[][] board, int row, int col) {
        //Left top diagonal
        for(int currRow = row, currCol = col; currRow>=0 && currCol>=0; currCol--, currRow--) {
            if(board[currRow][currCol] == 1)
                return false;
        }
        //Right down diagonal
        for(int currRow = row, currCol = col; currRow<board.length && currCol<board.length; currCol++, currRow++) {
            if(board[currRow][currCol] == 1)
                return false;
        }
        //Left down diagonal
        for(int currRow = row, currCol = col; currRow<board.length && currCol>=0; currCol--, currRow++) {
            if(board[currRow][currCol] == 1)
                return false;
        }
        //Right top diagonal
        for(int currRow = row, currCol = col; currRow>=0 && currCol<board.length; currCol++, currRow--) {
            if(board[currRow][currCol] == 1)
                return false;
        }
        return true;
    }
}
