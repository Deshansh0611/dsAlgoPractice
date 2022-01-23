package arrays;

import java.util.Arrays;

public class MergeSortedArraysInFirst {
    //Problem statement - https://leetcode.com/problems/merge-sorted-array/
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;

        int index = nums1.length - 1;
        m--;
        n--;
        while(index >= 0) {
            if(m<0) {
                nums1[index] = nums2[n--];
            } else if(n<0) {
                nums1[index] = nums1[m--];
            } else {
                if(nums1[m] > nums2[n])
                    nums1[index] = nums1[m--];
                else
                    nums1[index] = nums2[n--];
            }
            index--;
        }

        //Print output
        Arrays.stream(nums1).forEach(i -> System.out.print(i + " "));
    }
}
