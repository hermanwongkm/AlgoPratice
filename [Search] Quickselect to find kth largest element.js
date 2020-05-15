/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
    return quickSelect(nums,0,nums.length -1, nums.length - k);
    
};

const quickSelect = (nums,low,high,k) =>{
    let pivot = nums[high]; //Take the end as pivot
    let beforeIsLess = low;
    for(let i = low; i < high; i++){
        if(nums[i] < pivot){ //If it less than, i swap
            swap(nums,i,beforeIsLess);
            beforeIsLess++;
        }
    }
    swap(nums,beforeIsLess, high); //Swap to the correct position
    if(beforeIsLess === k){
        return nums[beforeIsLess];
    }
    else if(beforeIsLess < k){ //Less than k, means discard everything to left
        return quickSelect(nums,beforeIsLess + 1, high,k);
    }
    else{//means it is greater so discard everything to the right
        return quickSelect(nums,low, beforeIsLess - 1,k);
    }
}

const swap = (nums,i,j)=>{
    temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
