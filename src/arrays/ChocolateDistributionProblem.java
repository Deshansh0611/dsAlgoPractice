package arrays;

import java.util.Arrays;

//https://www.geeksforgeeks.org/chocolate-distribution-problem/
public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        int arr[] = {3, 4, 1, 9, 56, 7, 9, 12};
        int students = 5;
        System.out.println("Minimum possible difference is: " + findMinDiff(arr, students, arr.length));
    }

    private static int findMinDiff(int[] arr, int stud, int length) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i + stud - 1 < length; i++) {
            if (arr[i + stud - 1] - arr[i] < minDiff)
                minDiff = arr[i + stud - 1] - arr[i];
        }
        return minDiff;
    }
}
