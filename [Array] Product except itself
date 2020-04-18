/**
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Note: Please solve it without division and in O(n).
**/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length];
        
        //Answer will hold the product to the left of i 
        //Note it is to the left, because you never want to count yourself 
        ans[0] = 1; //Since there is no value to left of index 0, it is 1
        
        for(int i = 1; i < nums.length; i++){
            ans[i] = nums[i-1] * ans[i-1]; //The first index doesnt matter since it is 1
        }
        //Now, ans[i] will contain all the product to the left of i 
        
        // r will contain the product to the right of index i 
        int r = 1;
        for(int i = nums.length -1; i >= 0; i--){
            ans[i] = ans[i] * r; //So, everything to the left of my index, which is ans[i] * everything to the right of i which is r
            r = r * nums[i]; //Move to the next index, means everything to the right of this new index, so * current index
        }
        return ans;
    }
}
