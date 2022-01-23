package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeArraysWithoutExtraSpace {
    //Problem statement - https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
    public static void main(String[] args) {
        int arr1[] = {1, 5, 9, 10, 15, 20};
        int arr2[] = {2, 3, 8, 13};
        int end1 = arr1.length - 1;
        int start2 = 0;
        while(end1 >= 0 && start2 < arr2.length) {
            if(arr1[end1] < arr2[start2])
                //This means that both arrays are already sorted
                break;
            int temp = arr1[end1];
            arr1[end1] = arr2[start2];
            arr2[start2] = temp;
            end1--;
            start2++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        //Print result arrays
        Arrays.stream(arr1).forEach(n -> System.out.print(n + " "));
        System.out.println();
        Arrays.stream(arr2).forEach(n -> System.out.print(n + " "));
    }
}
