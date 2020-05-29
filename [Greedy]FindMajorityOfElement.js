/**
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3

 */
var majorityElement = function(nums) {
    let currNum = nums[0];
    count = 1;
    for(let i = 1; i < nums.length; i++){
        if(currNum === nums[i]){
            count++;
        }
        //From here is not equals
        else if(count > 0){
            count--;
        }
        else{ //count == 0, i will take thr curr as new currNum
            currNum = nums[i];
            count = 1;
        }
    }
    return currNum;
};
