# Given an integer array nums of unique elements, return all possible subsets (the power set).

# The solution set must not contain duplicate subsets. Return the solution in any order.


# Example 1:

# Input: nums = [1,2,3]
# Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

# Example 2:

# Input: nums = [0]
# Output: [[],[0]]

#BFS
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        for i in range(len(nums)):
            n = len(result)
            for j in range(n):
                nextSubnet = result[j].copy()
                nextSubnet.append(nums[i])
                result.append(nextSubnet)

        return result

#DFS recursive


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        subset = []
        # I want to perform DFS

        def backTrack(index, subset):
            result.append(subset.copy())
            # This is like going down 1 path and select all first so 1,2,3
            for i in range(index, len(nums)):
                print(i)
                subset.append(nums[i])
                backTrack(i + 1, subset)
                subset.pop()

        backTrack(0, subset)
        return result
