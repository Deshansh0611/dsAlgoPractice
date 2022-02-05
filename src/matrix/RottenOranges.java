package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    //Problem statement - https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
    //Meanings of 0, 1 , 2 -> 0 - no orange, 1 - fresh orange, 2 - rotten orange at that place
    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int grid[][] = { {2, 1, 0},
                        {1, 1, 1},
                        {1, 0, 0} };
        System.out.println("Time take to rot all oranges is - " + rotFreshOranges(grid));
    }

    private static int rotFreshOranges(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int totalOranges = 0;
        int rottenOranges = 0, timeTaken = 0;
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[i].length; j++) {
                if(grid[i][j] == 1 || grid[i][j] == 2)
                    totalOranges++;
                if(grid[i][j] == 2)
                    queue.offer(new Pair(i, j));
            }
        }

        if(totalOranges == 0)
            return 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            rottenOranges += size;
            if(rottenOranges == totalOranges)
                return timeTaken;
            timeTaken++;

            for(int i = 0; i< size; i++) {
                Pair pair = queue.peek();
                if(pair.x + 1 < grid.length && grid[pair.x + 1][pair.y] == 1) {
                    grid[pair.x + 1][pair.y] = 2;
                    queue.offer(new Pair(pair.x + 1, pair.y));
                }
                if(pair.x - 1 >= 0 && grid[pair.x - 1][pair.y] == 1) {
                    grid[pair.x - 1][pair.y] = 2;
                    queue.offer(new Pair(pair.x - 1, pair.y));
                }
                if(pair.y + 1 < grid[0].length && grid[pair.x][pair.y + 1] == 1) {
                    grid[pair.x][pair.y + 1] = 2;
                    queue.offer(new Pair(pair.x, pair.y + 1));
                }
                if(pair.y - 1 >= 0 && grid[pair.x][pair.y - 1] == 1) {
                    grid[pair.x][pair.y - 1] = 2;
                    queue.offer(new Pair(pair.x, pair.y - 1));
                }
                queue.poll();
            }
        }
        return -1;
    }
}
