/**
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

**/

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int ans = nums[0];  
        
        for(int i = 1; i < nums.length; i++){
            max = Math.max(nums[i], max + nums[i]);
            ans = Math.max(ans,max);
        }
        return ans;
    }
}
