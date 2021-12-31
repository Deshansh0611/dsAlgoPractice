package arrays;

import java.util.Arrays;

public class CountTriplets {
    //Problem statement - https://www.geeksforgeeks.org/count-triplets-such-that-one-of-the-numbers-can-be-written-as-sum-of-the-other-two/
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 8, 10};
        System.out.println("Possible triplets count: " + calculateTriplets(arr, arr.length));
    }

    private static int calculateTriplets(int[] arr, int length) {
        Arrays.sort(arr);
        int count = 0;
        for(int i = length - 1; i>0; i--) {
            int start = 0, end = i-1;
            while(start<end) {
                if(arr[start] + arr[end] < arr[i])
                    start++;
                else if (arr[start] + arr[end] > arr[i])
                    end--;
                else {
                    count++;
                    start++;
                    end--;
                }
            }
        }
        return count;
    }
}
