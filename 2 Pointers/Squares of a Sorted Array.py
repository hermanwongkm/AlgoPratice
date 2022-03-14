# Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

# Example 1:

# Input: nums = [-4,-1,0,3,10]
# Output: [0,1,9,16,100]
# Explanation: After squaring, the array becomes [16,1,0,9,100].
# After sorting, it becomes [0,1,9,16,100].

# Example 2:

# Input: nums = [-7,-3,2,3,11]
# Output: [4,9,9,49,121]


class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        leftIndex = 0
        rightIndex = len(nums) -1 #2
        result = []
        
        while leftIndex <= rightIndex:
            if nums[leftIndex] ** 2 <  nums[rightIndex] ** 2:
                result.append(nums[rightIndex] ** 2)
                rightIndex -= 1
            else:
                result.append(nums[leftIndex] ** 2)
                leftIndex += 1
        result.reverse()
        return result