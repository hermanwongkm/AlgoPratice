/**
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

**/
//This is a O(N^2)
//A outer loop to loop through every digit
// In each loop, there will be a low and high
//Shift the index based on the sum of both of these value, if its greater or smaller than necessary.

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length -2; i++){ //-2 as the last index will be used
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) { //To remove duplicates e.g. -1, -1, 0 So only check if it's not done yet because the array is sorted.
            int low = i + 1; 
            int high = nums.length-1;
            int sum = 0 - nums[i]; //This is the number you want to achieve 
            while(low < high){
                if(nums[low]+ nums[high] == sum){ //If this is the number you are looking for 
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low+1]) low++; //Remove duplicates, same as above, maybe the next number is the same number.
                    while (low < high && nums[high] == nums[high-1]) high--;
                    low++; //Move on because no duplicates. 
                    high--;
                } else if(nums[low] + nums[high] > sum){ 
                    //Current total greater than 0 means i need it to be smaller. Thus decrease my highest number.
                    high--;
                } else{
                    low++;
                }
            }
        }
     }
     return result;   
    }
}
