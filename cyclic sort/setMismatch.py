# You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

# You are given an integer array nums representing the data status of this set after the error.

# Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

# Example 1:

# Input: nums = [1,2,2,4]
# Output: [2,3]

# Example 2:

# Input: nums = [1,1]
# Output: [1,2]

class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        i = 0
        while i < len(nums):
            indexToSwap = nums[i] - 1
            if nums[indexToSwap] != nums[i]:
                nums[indexToSwap], nums[i] = nums[i], nums[indexToSwap]
            else:
                i += 1
                
        for i, value in enumerate(nums):
            if i + 1!= value:
                return [value, i + 1]