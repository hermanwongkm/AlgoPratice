/**
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
**/
//This algorithm invovles 2 pass. The first pass is a forward pass which sorts everything less than 1 to the left
//the second is a backwards pass which sorts everything greater than 1 to the right. Then it will be sorted.
class Solution {
    public void sortColors(int[] nums) {
        int pivot = 0;
        int start = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 1){
                swap(nums,i,start);
                start++;
            }
        }
        int end = nums.length - 1;
        for(int i = nums.length -1; i >= 0; i--){
            //You can also have another condition to check if it reaches 0,
            //because at that point it is already sorted.
            if(nums[i] > 1){
                swap(nums,i,end);
                end--;
            }
        }
    }
    
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}
