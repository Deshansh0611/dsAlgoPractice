package arrays;

import java.util.PriorityQueue;

public class ThirdMaximumNumber {
    //Problem statement - https://leetcode.com/problems/third-maximum-number
    public static void main(String[] args) {
        int[] nums = {1, 10, 19, 4, 8, 19, 2};
        System.out.println("Third max using not so generic method: "
                + findThirdMaximumUsingNotSoGenericMethod(nums));
        System.out.println("Third max using generic method with the help of heap: "
                + findThirdMaximumUsingHeap(nums));
    }

    private static int findThirdMaximumUsingNotSoGenericMethod(int[] nums) {
        Integer max = null;
        Integer secondMax = null;
        Integer thirdMax = null;
        for(Integer num: nums) {
            if(num.equals(max) || num.equals(secondMax) || num.equals(thirdMax))
                continue;
            if(max == null || num > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            } else if(secondMax == null || num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if(thirdMax == null || num > thirdMax) {
                thirdMax = num;
            }
        }
        return thirdMax == null? max: thirdMax;
    }

    private static int findThirdMaximumUsingHeap(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: nums) {
            if(minHeap.contains(num))
                continue;
            minHeap.add(num);
            if(minHeap.size() > 3)
                minHeap.remove();
        }
        //Adding this block to ensure we return max element in case there is no third max
        if(minHeap.size() != 3) {
            while(minHeap.size() != 1)
                minHeap.remove();
        }
        return minHeap.remove();
    }
}
