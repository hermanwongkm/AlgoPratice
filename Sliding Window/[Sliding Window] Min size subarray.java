// Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

// Example: 

// Input: s = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: the subarray [4,3] has the minimal length under the problem constraint.

// Follow up:
// If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int back = 0;
        int count = 0;
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            count = count  + nums[i];
            while(count >= s){
                ans = Math.min(ans,i - back + 1); //Because at this point, you have not minus it away yet
                count = count - nums[back];
                back++;
            }
            
        }
        return (ans != Integer.MAX_VALUE? ans : 0); 
    }
}
