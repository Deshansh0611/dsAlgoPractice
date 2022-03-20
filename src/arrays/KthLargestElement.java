package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {1, 10, 5, 3, 12, 10};
        int k = 4;
        System.out.println(k + "th largest number using brute force: " + getKthLargestUsingBruteForce(nums, k));
        System.out.println(k + "th largest number using minHeap: " + getKthLargestUsingBruteForce(nums, k));
    }

    private static int getKthLargestUsingBruteForce(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    private static int getKthLargestUsingMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: nums) {
            minHeap.add(num);
            if(minHeap.size() > k)
                minHeap.remove();
        }
        return minHeap.remove();
    }
}
