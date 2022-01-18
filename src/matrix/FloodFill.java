package matrix;

public class FloodFill {
    //Problem statement - https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/
    public static void main(String[] args) {
        int[][] screen = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        int newColor = 3;
        int sourceRow = 4;
        int sourceCol = 4;

        //Handles the case when element to change is already new color
        if(screen[sourceRow][sourceCol] == newColor)
            return;

        int sourceColor = screen[sourceRow][sourceCol];
        int rows = screen.length;
        int cols = screen[0].length;
        dfs(screen, rows, cols, sourceColor, newColor, sourceRow, sourceCol);
        printScreen(screen, rows, cols);
    }

    private static void dfs(int[][] screen, int rows, int cols,
                            int sourceColor, int newColor, int sourceRow, int sourceCol) {
        if(sourceRow >= rows || sourceRow < 0 || sourceCol >= cols
                || sourceCol < 0 || screen[sourceRow][sourceCol] != sourceColor)
            return;
        screen[sourceRow][sourceCol] = newColor;
        dfs(screen, rows, cols, sourceColor, newColor, sourceRow - 1, sourceCol);
        dfs(screen, rows, cols, sourceColor, newColor, sourceRow + 1, sourceCol);
        dfs(screen, rows, cols, sourceColor, newColor, sourceRow, sourceCol - 1);
        dfs(screen, rows, cols, sourceColor, newColor, sourceRow, sourceCol + 1);
    }

    private static void printScreen(int[][] screen, int rows, int cols) {
        for (int i = 0; i<rows; i++) {
            for(int j = 0; j<cols; j++) {
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
    }
}
