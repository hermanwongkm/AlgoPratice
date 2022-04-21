# Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

# The solution set must not contain duplicate subsets. Return the solution in any order.

 

# Example 1:

# Input: nums = [1,2,2]
# Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

# Example 2:

# Input: nums = [0]
# Output: [[],[0]]

class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        startIndex = 0
        endIndex = 0
        
        nums.sort()
        for i in range(len(nums)):
            startIndex = 0
            if i > 0 and nums[i] == nums[i -1]: #If duplicate, i want to loop through only previous subnets added
                startIndex = endIndex  #So we take the previous end len. Dont have to add 1 as it is length
            endIndex = len(result) #This is your normal end of subset length
            
            for j in range(startIndex, endIndex): #Looping through your subsets
                subset = result[j].copy()
                subset.append(nums[i])
                result.append(subset)
                    
        return result
                    