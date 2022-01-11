package arrays;

import java.util.Arrays;

public class NextGreaterElementWithoutStack {
    //Problem statement - https://www.geeksforgeeks.org/next-greater-element/
    public static void main(String[] args) {
        int[] arr = {13, 15, 6, 12, 13, 6};
        calculateNextGreaterElement(arr);
    }

    private static void calculateNextGreaterElement(int[] arr) {
        if(arr.length == 0)
            return;
        int maxSoFar = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for(int i = arr.length - 2; i>=0; i--) {
            if(arr[i] >= maxSoFar) {
                maxSoFar = arr[i];
                arr[i] = -1;
            } else if (arr[i] < maxSoFar) {
                arr[i] = maxSoFar;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
