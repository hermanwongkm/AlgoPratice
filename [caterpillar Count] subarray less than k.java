/**
Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:

Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

**/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int start = 0;
        int end = 0;
        int count = 0;
        int product = 1;
        while(start < nums.length && end < nums.length){
            product = product * nums[end];
            //This while condition will move the left forward until the product is not greater than k
            while(product >= k && start < nums.length){
                product = product/nums[start];
                start++;
            }
            //By doing end-start + 1,
            //The +1 will count the single element by itself,
            //The end -start will count the possible contigious length for example 
            //If theres 4 value 1 2 3 4
            //it will be 3 - 0 = 3 counts. which are, {1,2} {1,2,3} {1,2,3,4}
            //And the + 1 will count for the 1.
            //Imagine a line, to 4 minus 2.
             count = count + (end-start) + 1;
            end++;
        }
        return count;
    }
}
