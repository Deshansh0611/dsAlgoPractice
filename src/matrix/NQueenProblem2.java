package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class NQueenProblem2 {
    //Problem statement - https://leetcode.com/problems/n-queens
    //In this variation, we are printing all possible solutions
    static List<List<String>> solutions = new ArrayList<>();
    public static void main(String[] args) {
        int boardSize = 4;
        char[][] board = new char[boardSize][boardSize];
        for(char[] row: board)
            Arrays.fill(row, '.');
        solveNQueen(board, 0);
        printSolutions();
    }

    private static boolean solveNQueen(char[][] board, int row) {
        if(row == board.length) {
            addToSolution(board);
            return true;
        }
        for(int col = 0; col<board[row].length; col++) {
            if(isSafePlacement(board, row, col)) {
                board[row][col] = 'Q';
                solveNQueen(board, row+1);
                //Only change here from original n queen problem is we don't return true
                //and keep on resetting all values after 1 possible solution is found
                board[row][col] = '.';
            }
        }
        return false;
    }

    private static void addToSolution(char[][] board) {
        List<String> currSol = new ArrayList<>();
        for(char[] row: board) {
            String s = "";
            for(char val: row) {
                s += val;
            }
            currSol.add(s);
        }
        solutions.add(currSol);
    }

    private static boolean isSafePlacement(char[][] board, int row, int col) {
        if(isSafeInRow(board, row, col) && isSafeInCol(board, row, col) && isSafeInDiagonal(board, row, col))
            return true;
        return false;
    }

    private static boolean isSafeInRow(char[][] board, int row, int col) {
        for(int i = 0; i<board.length; i++) {
            if(board[row][i] == 'Q')
                return false;
        }
        return true;
    }

    private static boolean isSafeInCol(char[][] board, int row, int col) {
        for(int i = 0; i<board.length; i++) {
            if(board[i][col] == 'Q')
                return false;
        }
        return true;
    }

    private static boolean isSafeInDiagonal(char[][] board, int row, int col) {
        //Left top diagonal
        for(int currRow = row, currCol = col; currRow>=0 && currCol>=0; currCol--, currRow--) {
            if(board[currRow][currCol] == 'Q')
                return false;
        }
        //Right down diagonal
        for(int currRow = row, currCol = col; currRow<board.length && currCol<board.length; currCol++, currRow++) {
            if(board[currRow][currCol] == 'Q')
                return false;
        }
        //Left down diagonal
        for(int currRow = row, currCol = col; currRow<board.length && currCol>=0; currCol--, currRow++) {
            if(board[currRow][currCol] == 'Q')
                return false;
        }
        //Right top diagonal
        for(int currRow = row, currCol = col; currRow>=0 && currCol<board.length; currCol++, currRow--) {
            if(board[currRow][currCol] == 'Q')
                return false;
        }
        return true;
    }

    private static void printSolutions() {
        for(List<String> str: solutions) {
            Stream.of(str).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
    }
}
