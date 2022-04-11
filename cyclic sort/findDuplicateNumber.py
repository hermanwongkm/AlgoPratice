# Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

# There is only one repeated number in nums, return this repeated number.

# You must solve the problem without modifying the array nums and uses only constant extra space.

 

# Example 1:

# Input: nums = [1,3,4,2,2]
# Output: 2

# Example 2:

# Input: nums = [3,1,3,4,2]
# Output: 3


def find_duplicate(nums):
  i = 0
  while i < len(nums):
    if nums[i] != i + 1: #Condition to check if it is at the right place already
      j = nums[i] - 1
      if nums[i] != nums[j]:
        nums[i], nums[j] = nums[j], nums[i]  # swap
      else:  # Because everything is moved up by 1. if you found a number equal to the index, its a duplicate
        return nums[i]
    else:
      i += 1

  return -1

class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        i = 0
        while i < len(nums):
            indexToSwap = nums[i] - 1
            if nums[indexToSwap] != nums[i]:
                nums[indexToSwap], nums[i] = nums[i], nums[indexToSwap]
            elif i >= nums[indexToSwap] :
                return nums[indexToSwap]
            else:
                i += 1
        
#Final O(1) Space

class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        # 'low' and 'high' represent the range of values of the target
        low = 1
        high = len(nums) - 1
        
        while low <= high:
            cur = (low + high) // 2
            count = 0

            # Count how many numbers are less than or equal to 'cur'
            count = sum(num <= cur for num in nums)
            if count > cur:
                duplicate = cur
                high = cur - 1
            else:
                low = cur + 1
                
        return duplicate