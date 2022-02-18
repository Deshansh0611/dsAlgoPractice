package matrix;

import java.util.Arrays;
import java.util.stream.Stream;

public class WallsAndGates {
    //Problem statement - https://www.youtube.com/watch?v=Pj9378ZsCh4
    public static void main(String[] args) {
        int[][] rooms = {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        System.out.println("Input matrix before rearrangements:");
        Stream.of(rooms).map(Arrays::toString).forEach(System.out::println);

        for(int i = 0; i<rooms.length; i++) {
            for(int j = 0; j<rooms[i].length; j++) {
                if(rooms[i][j] == 0)
                    dfs(rooms, i, j, 0);
            }
        }

        //Print output
        System.out.println("Output matrix after rearrangements:");
        Stream.of(rooms).map(Arrays::toString).forEach(System.out::println);
    }

    private static void dfs(int[][] rooms, int i, int j, int count) {
        if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length || rooms[i][j] < count)
            return;
        rooms[i][j] = count;
        dfs(rooms, i+1, j, count + 1);
        dfs(rooms, i-1, j, count + 1);
        dfs(rooms, i, j+1, count + 1);
        dfs(rooms, i, j-1, count + 1);
    }
}
