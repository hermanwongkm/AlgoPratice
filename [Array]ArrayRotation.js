/**
Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    Could you do it in-place with O(1) extra space?

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]


 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    const rotations = k % nums.length;
    let count = 0; //This count will keep track of the number of swaps you made
    for(let i = 0; i <= k; i++){ //You will never visit the same element twice, because it is a cycle of e.g. 3 3 3 3 or 2 2 2 2.
        if(count === nums.length){
            break;
        }
        let flag = true;
        let prevValue = nums[i];
        let currIndex = i;
        while(flag){
            currIndex = (currIndex + rotations) % nums.length;
            let temp = nums[currIndex];
            nums[currIndex] = prevValue;
            prevValue = temp;
            count++;
            if(currIndex === i){ //If i go back to where i was before, meaning i made a complete cycle. 
                flag = false;
            }
        }
    }
};
