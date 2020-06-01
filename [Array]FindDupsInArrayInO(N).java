/**
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

**/
//The question says a[i] will be between the size of n. We can make use of this property to solve it.
//If we seen the number berfore, we multiple it by -1. Thus, if we see a negative number, it means it is a duplicate.
//We use the value as the index of the array. 
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                ans.add(Math.abs(nums[i]));
            }else{
                nums[index] = nums[index] * -1;
            }
        }
        return ans;
    }
}
