# Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

#     0 <= a, b, c, d < n
#     a, b, c, and d are distinct.
#     nums[a] + nums[b] + nums[c] + nums[d] == target

# You may return the answer in any order.

 

# Example 1:

# Input: nums = [1,0,-1,0,-2,2], target = 0
# Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        # -2, -1, 0, 0, 1, 2
        result = []
        nums.sort()
        for p1Index in range(0, len(nums)):
            if p1Index > 0 and nums[p1Index] == nums[p1Index - 1]:
                continue #These 2 condition checks are for things like 2,2,2,2,2 8
            for p2Index in range(p1Index + 1, len(nums)):
                if p2Index > p1Index + 1 and nums[p2Index] == nums[p2Index - 1]: #When it is not the first round
                    continue
                leftIndex = p2Index + 1
                rightIndex = len(nums) - 1
                while leftIndex < rightIndex:
                    sum = nums[p1Index] + nums[p2Index] + nums[leftIndex] + nums[rightIndex]
                    if sum == target:
                        result.append([nums[p1Index],nums[p2Index],nums[leftIndex],nums[rightIndex]])
                        leftIndex += 1
                        rightIndex -= 1
                        while(leftIndex < rightIndex and nums[leftIndex] == nums[leftIndex-1]):
                            leftIndex += 1
                        while(leftIndex < rightIndex and nums[rightIndex] == nums[rightIndex+1]):
                            rightIndex -= 1
                    elif sum < target:
                        leftIndex += 1
                    else:
                        rightIndex -=1
        return result