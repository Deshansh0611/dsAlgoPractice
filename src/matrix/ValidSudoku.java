package matrix;

public class ValidSudoku {
    private static int GRID_SIZE = 9;
    public static void main(String[] args) {
        char[][] board = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}
        };
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[i].length; j++) {
                if(board[i][j] != '.') {
                    if(!isValidPlacement(i, j, board[i][j], board))
                        return false;
                }
            }
        }
        return true;
    }

    private boolean isValidPlacement(int row, int col, char num, char[][] board) {
        return isPresentInRow(row, col, num, board)
                && isPresentInCol(row, col, num, board)
                && isPresentInBox(row, col, num, board);
    }

    private boolean isPresentInRow(int row, int col, char num, char[][] board) {
        for(int i = 0; i<board.length; i++) {
            if(i != col && board[row][i] == num)
                return false;
        }
        return true;
    }

    private boolean isPresentInCol(int row, int col, char num, char[][] board) {
        for(int i = 0; i<board.length; i++) {
            if(i != row && board[i][col] == num)
                return false;
        }
        return true;
    }

    private boolean isPresentInBox(int row, int col, char num, char[][] board) {
        int boxStartRowIndex = row - row%3;
        int boxStartColIndex = col - col%3;
        for(int i = boxStartRowIndex; i<boxStartRowIndex + 3; i++) {
            for(int j = boxStartColIndex; j<boxStartColIndex + 3; j++) {
                if((i != row && j != col)
                        && board[i][j] == num)
                    return false;
            }
        }
        return true;
    }
}
