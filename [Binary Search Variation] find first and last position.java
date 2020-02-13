/**
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]


**/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] ans = {-1,-1};
        if(nums.length < 1){
            return ans;
        }
        
        while (start < end){
            int mid = (start + end)/2;
            //For left
            //If nums[mid] == target, i know its between start & end
            //We want to confirm that this is the last index that holds this value
            //The only way to confirm is break out of the loop when start == end
            //The only way we can gurantee it is by moving the end to the left
            //If we move the start to the right, and nums[mid] == target it would be wrong
            //So i will have to shift the end down to this instead of the opposite
            //If i am shifting down end to mid, it means 
            if(nums[mid] == target || nums[mid] > target){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }

        if(nums[start] != target){ //If the value does not exist 
            return ans; 
        }
        ans[0] = start;
        //2 2 2 3 4
        start = 0;
        end = nums.length;
        while (start < end){
            int mid = (start + end)/2;
            //For right
            //We know it is between start and end
            //But we want to find the right max now
            //so if the nums[mid] == target and happen to be the last
            //we want the start to take this number
            //because we know it is between start and end
            //So if it is equals, you will bring your start towards the end. Shifting right. 
            if(nums[mid] > target){
                end = mid;
            }
            else{
                start = mid + 1;
            }
            ans[1] = end - 1 ; //I have to minus one as it will eventually find break out of the loop
            //You can trace 2 2 2 3 4 and it will end at 3 if k = 2.
        }
     return ans;   
    }
}
