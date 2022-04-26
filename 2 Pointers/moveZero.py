# Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

# Note that you must do this in-place without making a copy of the array.


# Example 1:

# Input: nums = [0,1,0,3,12]
# Output: [1,3,12,0,0]

# Example 2:

# Input: nums = [0]
# Output: [0]

# 2 pointer method
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        lastNonZeroIndex = 0

        for i in range(len(nums)):
            if nums[i] != 0:
                nums[lastNonZeroIndex] = nums[i]
                lastNonZeroIndex += 1

        for j in range(lastNonZeroIndex, len(nums)):
            nums[j] = 0

#Swap method


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        currIndex = 0
        lastZeroIndex = 0

        for currIndex in range(len(nums)):
            if nums[currIndex] == 0:
                continue
            else:
                nums[currIndex], nums[lastZeroIndex] = nums[lastZeroIndex], nums[currIndex]
                lastZeroIndex += 1
