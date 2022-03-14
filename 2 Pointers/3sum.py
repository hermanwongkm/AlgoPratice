# Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

# Notice that the solution set must not contain duplicate triplets.

 

# Example 1:

# Input: nums = [-1,0,1,2,-1,-4]
# Output: [[-1,-1,2],[-1,0,1]]


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        print(nums)
        result = []
        for index in range(len(nums)):
            if index == 0  or nums[index] != nums[index - 1]: # So that index 0 will not bug out 
                leftIndex = index + 1
                rightIndex = len(nums) - 1
                target = 0 - nums[index]
                while leftIndex < rightIndex:
                    sum = nums[leftIndex] + nums[rightIndex]
                    if sum == target:
                        result.append([nums[index],nums[leftIndex],nums[rightIndex]])
                        leftIndex += 1
                        rightIndex -= 1
                        # Remove duplicates
                        while nums[leftIndex] == nums[leftIndex -1] and leftIndex < rightIndex:
                            leftIndex += 1
                        while nums[rightIndex] == nums[rightIndex +1] and leftIndex < rightIndex:
                            rightIndex -= 1
                    elif sum < target:
                        leftIndex += 1
                    else:
                        rightIndex -= 1
        return result
                