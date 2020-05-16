/**
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.



 * @param {number[]} nums
 * @return {number}
 */
 
 /**
 the idea is to first store everything inside the set
 Now, you will slowly remove those ++ and -- of this value.
 You also do not need to revisit it, because you already taken it into consideration
 Runtime o(N)
 **/
var longestConsecutive = function(nums) {
    let set = new Set();
    let ans = 0;
    
    for(let i = 0; i < nums.length; i ++){
        set.add(nums[i]);
    }
    
    for(let i = 0; i < nums.length; i++){
        if(set.has(nums[i])){
            set.delete(nums[i]);
            let lower = nums[i] - 1;
            while(set.has(lower)){
                set.delete(lower);
                lower--;
            }
            
            let higher = nums[i] + 1;
            while(set.has(higher)){
                set.delete(higher);
                higher++;
            }
            ans = Math.max(ans, higher - lower -1);
        }
    }
    return ans;
};

