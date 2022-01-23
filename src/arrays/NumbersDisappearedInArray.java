package arrays;

public class NumbersDisappearedInArray {
    //Problem statement - https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        for(int i = 0; i<arr.length; i++) {
            int curr = Math.abs(arr[i]);
            arr[curr-1] = -(Math.abs(arr[curr-1]));
        }
        System.out.println("Printing missing numbers:");
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] > 0)
                System.out.println(i+1);
        }
    }
}
