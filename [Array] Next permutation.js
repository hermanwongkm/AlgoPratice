/**
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

**/

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
 
 //The idea is to 
 //1. Find the index where it is no longer strictly decreasing. 
 //1.1 This works because, we cannot get a greater value by simply modifying this value e.g. 54321. It is already the largest possible
 //2. Then, we take the value just before this section. And this works because, the section was previously not decreasing but it stopped
 //So this number is definitely greater than some number we seen previously.
 //Next, we swap this number with the next greater number possible than this number to minimize the increase.
 //However, now, this value may not be the smallest value possible. 
 //But since we know it is strictly increasing. We can just reverse it to get the next smallest value.
var nextPermutation = function(nums) {
    let i = nums.length - 2;
    //This is used to find the section that is strictly decreasing
    while(nums[i] >= nums[i+1] && i >= 0){
        i--;
    }
    if(i >= 0){ //Only if you found a position to swap then you will perform the swap
    //So now, when it breaks, i is the position that you want to used to compare
    //Now, within the section, you will find a position that is greater than value at i
        let j = nums.length - 1;
        while(j >= 0 && nums[j] <= nums[i]){
            j--;
        }
    //Now, at position j, it is the value you want to swap
        swap(nums,i,j);
    }
    //Now after you swapped them, you need to reverse the value from the swap section
    reverse(nums, i + 1);
    console.log(nums);
    return nums;
};

//method to reverse 
//Do not need end because it reverse till the end
const reverse = (nums, start) =>{
    let end = nums.length - 1;
    while(start < end){
        swap(nums,start,end);
        start++;
        end--;
    }
}

const swap = (nums, i, j) =>{
    temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
