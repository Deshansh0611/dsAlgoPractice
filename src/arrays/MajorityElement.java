package arrays;

public class MajorityElement {
    //Problem statement - https://leetcode.com/problems/majority-element/
    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 4, 4};
        int majorityElement = findMajorityElement(nums);
        if ((majorityElement != -1)) {
            System.out.println("Majority element is " + majorityElement);
        } else {
            System.out.println("No majority element found!");
        }
    }

    private static int findMajorityElement(int[] nums) {
        if(nums.length == 0)
            return -1;
        if(nums.length == 1)
            return nums[0];
        int ans = nums[0];
        int count = 1;
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] == ans) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    ans = nums[i];
                    count++;
                }
            }
        }
        count = 0;
        for (int elm: nums) {
            if (elm == ans)
                count++;
        }
        if(count > nums.length/2)
            return ans;
        return -1;
    }
}
