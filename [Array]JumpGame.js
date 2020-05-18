Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

//The idea is that you keep track of the furthest index we know we can advance to and at the end check if i can reach or not.

var canJump = function(nums) {
    let furthestSoFar = 0;
    for(let i = 0; i < nums.length; i++){
        if(i <= furthestSoFar){
            furthestSoFar = Math.max(i + nums[i], furthestSoFar);
        }
    }
    return furthestSoFar >= nums.length - 1;
};
