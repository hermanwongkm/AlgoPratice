/**
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
**/
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 0){
            return 0;
        }
        int replace = 0;
        int prev = nums[0];
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(prev == nums[i]){
                if(count < 2){
                    nums[replace] = nums[i]; //If its at the start, replace and i will be the same. So i am just replacing it with itself. 
                    count++;
                    replace++;
                }
            }
            else{
                prev = nums[i];
                nums[replace] = nums[i];
                count = 1;
                replace++;
            }
        }
        return replace;
    }
}
