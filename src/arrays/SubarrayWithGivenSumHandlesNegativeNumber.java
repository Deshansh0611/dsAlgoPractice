package arrays;

import java.util.HashMap;

public class SubarrayWithGivenSumHandlesNegativeNumber {
    //Problem statement: https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int length = arr.length;
        int sum = -10;
        findSubArray(arr, length, sum);
    }

    private static void findSubArray (int[] arr, int length, int sum) {
        int start = 0;
        int end = -1;
        int currentSum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<length; i++) {
            currentSum += arr[i];
            // Below case handles situation when start index do not move and we find subarray starting index 0
            if(currentSum == sum) {
                end = i;
                break;
            } else if(map.containsKey(currentSum - sum)) {
                start = map.get(currentSum - sum) + 1;
                end = i;
                break;
            } else {
                map.put(currentSum, i);
            }
        }
        if(end == -1)
            System.out.println("No such subarray exists!");
        else
            System.out.println("Subarray found between indexes " + start + " to " + end);
    }
}
