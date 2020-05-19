/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    let ans = [-1,-1];
    ans[0] = binarySearch(nums,target,true);
    if(nums[ans[0]] !== target){
        return [-1,-1]; //means the target does not exist
    }
    ans[1] = binarySearch(nums,target,false) -1; //Note that there is a minus one here because you did a mid + 1. And if so happen it is the last element. You need to go back.
    return ans;
    
};

const binarySearch = (nums,target,left) =>{
    let start = 0;
    let end = nums.length;
    while(start < end){
        let mid = start + Math.floor((end - start)/2);
        if(nums[mid] > target || (left && nums[mid] == target)){ //means target on the left 
            end = mid;
        }
        else{ //means target on the right
            start = mid + 1;
        }
    }
    return start;
}
