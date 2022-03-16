package arrays;

public class SearchInsertPosition {
    //Problem statement - https://leetcode.com/problems/search-insert-position/
    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 6};
        int input = 6;
        System.out.println("Search index position for input " + input + " is: " + findSearchIndex(nums, input));
    }

    private static int findSearchIndex(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start<=end) {
            int mid = (start + end)/2;
            if(target == nums[mid])
                return mid;
            if(target < nums[mid])
                end = mid-1;
            else if(target > nums[mid])
                start = mid+1;
        }
        return start;
    }
}
