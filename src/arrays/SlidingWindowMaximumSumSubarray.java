package arrays;

public class SlidingWindowMaximumSumSubarray {
    //Problem statement -> You have an array and a window as input. You need to calculate all subarrays of size as window.
    //Now, return the subarray with maximum sum. Example - For array - {1, 5, 3, -2, 0, 13} and window - 3
    //Calculate  all subarrays of size 3 like {1, 5, 3}, {5, 3, -2}
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, -2, 0, 13};
        int window = 4;
        calculateMaxSubArraySum(arr, window);
    }

    private static void calculateMaxSubArraySum(int[] arr, int window) {
        int currSum = 0;
        for(int i = 0; i<window; i++) {
            currSum += arr[i];
        }
        int maxSum = currSum;
        int start = 0, end = window-1;
        for(int i = 0; i<arr.length - window; i++) {
            currSum = currSum - arr[start++] + arr[++end]; //9-1-2 = 6
            if(currSum > maxSum)
                maxSum = currSum;
        }
        System.out.println(maxSum);
    }
}
