package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class subarrayWithGivenSum {
    //Problem statement - https://www.geeksforgeeks.org/find-subarray-with-given-sum/
    public static void main(String[] args) {
        int arr[] = {135, 101, 170, 125, 79, 159, 163, 65, 106,
                146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103,
                154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70,
                113, 68, 100, 36, 95, 104, 12, 123, 134};
        System.out.println(subArraySum(arr, 42, 468));
    }

    static ArrayList<Integer> subArraySum(int[] arr, int size, int sum) {
        int currSum = 0;
        for(int start = 0, end = 0; start<size && end<=size;) {
            if(currSum < sum) {
                /*Putting this condition here as in case end is at the last of array,
                  and now we need to check for all values of start, end<size would fail as end = size.
                  Hence, changing condition to end<=size and if end=size,
                  we restrict code to enter this block to add arr[end] to currSum
                */
                if(end>=size)
                    break;
                currSum += arr[end++];
            } else if(currSum > sum)
                currSum -= arr[start++];
            else
                return new ArrayList<Integer>(Arrays.asList(start+1, end));
        }
        return new ArrayList<Integer>(Arrays.asList(-1));
    }
}
