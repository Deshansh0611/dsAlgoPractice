package arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    //Problem statement - https://leetcode.com/problems/3sum/submissions/
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        findThreeSums(nums).stream().forEach(System.out::println);
    }

    private static List<List<Integer>> findThreeSums(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length - 2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int requiredSum = 0 - nums[i];
                int start = i+1, end = nums.length - 1;
                while(start<end) {
                    int currSum = nums[start] + nums[end];
                    if(currSum > requiredSum) {
                        end--;
                    } else if(currSum < requiredSum) {
                        start++;
                    } else {
                        output.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        while(start<end && nums[start] == nums[start+1])
                            start++;
                        while(start<end && nums[end] == nums[end-1])
                            end--;
                        start++;
                        end--;
                    }
                }
            }
        }
        return output;
    }
}
