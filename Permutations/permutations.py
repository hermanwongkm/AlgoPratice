# Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.


# Example 1:

# Input: nums = [1,2,3]
# Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

# Example 2:

# Input: nums = [0,1]
# Output: [[0,1],[1,0]]

# Example 3:

# Input: nums = [1]
# Output: [[1]]

from collections import deque


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        #Since we need to return all possible permutation, we cannot use an array to store the subset permanently
        #Hence, we will use a queue to store this intermidient state
        queue = deque([[]])
        for i in range(len(nums)):
            # I will loop through the existing subsets
            numberOfSubsets = len(queue)
            for j in range(numberOfSubsets):
                currentSubset = queue.popleft()  # Get the subset
                # now, inside the subset i need to insert this new value at every possible position, INCLUDING last index
                for k in range(len(currentSubset) + 1):
                    newSubset = currentSubset.copy()
                    # Insert at the possible positions
                    newSubset.insert(k, nums[i])
                    # this is your answer because all possible permutations are in
                    if len(newSubset) == len(nums):
                        result.append(newSubset)
                    else:  # This is still a intermidient state
                        queue.append(newSubset)
        return result

# DFS


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        subset = []

        def backTrack(subset):
            if(len(subset) == len(nums)):
                result.append(subset.copy())
            else:  # I need to do start from 1
                for i in range(len(nums)):
                    if nums[i] in subset:
                        continue
                    subset.append(nums[i])
                    backTrack(subset)
                    subset.pop()

        backTrack(subset)
        return result
