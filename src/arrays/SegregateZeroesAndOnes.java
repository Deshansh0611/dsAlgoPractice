package arrays;

import java.util.Arrays;

public class SegregateZeroesAndOnes {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 1};
        segregate(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void segregate(int[] arr) {
        int start = 0, end = arr.length - 1;
        int temp;
        while(start<end) {
            if(arr[start] == 0) {
                start++;
                continue;
            } else if(arr[end] == 1) {
                end--;
                continue;
            } else {
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    }
}
