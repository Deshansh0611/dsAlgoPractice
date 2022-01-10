package arrays;

import java.util.Arrays;

public class MoveZeroesToEnd {
    //https://www.geeksforgeeks.org/move-zeroes-end-array-set-2-using-single-traversal/
    public static void main(String[] args) {
        int[] arr = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZeroes(int[] arr) {
        int countOfNonZero = 0;
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] != 0) {
                arr[countOfNonZero++] = arr[i];
            }
        }
        while(countOfNonZero < arr.length) {
            arr[countOfNonZero++] = 0;
        }
    }
}
