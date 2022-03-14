# Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

# Return the sum of the three integers.

# You may assume that each input would have exactly one solution.

 

# Example 1:

# Input: nums = [-1,2,1,-4], target = 1
# Output: 2
# Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

# We can use the two pointer method to reduce complexity to O(N^2). We begin by sorting the array.
# Now we use three indices i,j and k. We iterate i from 0 to N (actually till N-2 is fine). We initialize j to i+1 and k to N-1.
# Now we compute curr_sum = nums[i]+nums[j]+nums[k]. If this equals target, we have the closest sum.
# Otherwise update closest_sum using the rule abs(curr_sum-target) < abs(closest_sum-target).
# Now what if curr_sum is less than target. Should we test (nums[i]+nums[j]+nums[k-1]), (nums[i]+nums[j]+nums[k-2]), (nums[i]+nums[j]+nums[k-3]) ? The answer is NO. All of these triplets will be less than curr_sum. And curr_sum is less than target - so there is no point testing these triplets. We must move forward by advancing j to j + 1 in the hope to get a larger triplet. This is the main intuition in this problem.

class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort() 
        closestSum = math.inf
        for index, value in enumerate(nums):
            leftIndex = index + 1
            rightIndex = len(nums) - 1
            while leftIndex < rightIndex: # dont have to worry out of bound because of this condition
                sum = value + nums[leftIndex] + nums[rightIndex]
                if sum == target:
                    return target
                elif abs(target-sum) < abs(target-closestSum): #Does not matter if we target minus target or vice versa
                    closestSum = sum
                
                if sum < target:
                    leftIndex += 1
                else:
                    rightIndex -= 1
        
        return closestSum
            