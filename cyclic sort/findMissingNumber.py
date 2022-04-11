# Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

# Example 1:

# Input: nums = [3,0,1]
# Output: 2
# Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

# Example 2:

# Input: nums = [0,1]
# Output: 2
# Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

# Example 3:

# Input: nums = [9,6,4,2,3,5,7,0,1]
# Output: 8
# Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        array = [None] * (len(nums) + 1)
        for num in nums:
            array[num] = 1
        
        for i in range(len(array)):
            if array[i] == None:
                return i
        

#O(N) space solution

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        i = 0
        while i < len(nums):
            indexToSwap = nums[i]
            #The first condition checks if its out of range or not. If you are swapping the last one, jsut proceed
            #The second condition checks of the current value is what i want to swap with. So if its the same, means it is in the correct position
            if indexToSwap < len(nums) and  nums[indexToSwap] != nums[i]:
                nums[i], nums[indexToSwap] = nums[indexToSwap], nums[i]
            else:
                i += 1
        
        print(nums)
        for i in range(len(nums)):
            if i != nums[i]:
                return i
            
          #If i got here, it means that the last element is missing
        return len(nums)