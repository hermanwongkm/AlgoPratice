/**
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

**/

class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int temp = max;
            //If it is all positive, the max will continue to grow
            //If it was previously a min (negative) and this is also a negative it will become positive
            //Its possible that the previous numbers are 0 so you need to max with the current element.
            //Even if the current value is 0, you are still multiplying. And Thus it will become 0 no matter what. Thus thats not why you math.max with nums[i]
            //You do that because, if the previous value is 0, you want to take the current index as value 
            max = Math.max(Math.max(nums[i] * max, nums[i] * min),nums[i]); 
            //But you also want to keep track of the min since if its a negative number and the next might make it positive
            min = Math.min(Math.min(nums[i] * temp, nums[i] * min), nums[i]);
            
            if(max > result){
                result = max;
            }
        }
        return result;
    }
}
