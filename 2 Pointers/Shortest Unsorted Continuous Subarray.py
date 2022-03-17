# Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

# Return the shortest such subarray and output its length.

 

# Example 1:

# Input: nums = [2,6,4,8,10,9,15]
# Output: 5
# Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

# Example 2:

# Input: nums = [1,2,3,4]
# Output: 0


class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
         # [2,6,8,4,10,9,15,17,18]
        #  [2,4,6,8,9,10,15,17,18]
        startPointer = endPointer = 0
        largestNumberSofar = 0
        for index in range(len(nums) - 1):
            if nums[index] > nums[index + 1]: #Found the start of canidate array
                startPointer = index
                break
                
        for index in range(len(nums) - 1, 0, -1):
            if nums[index] < nums[index - 1]:
                endPointer = index
                break
        
        #If i managed to loop through the end, means its sorted and i can avoid the + 1 at the end
        if startPointer == endPointer:
            return 0
        
        #Now at this point we got the start and end of the candidate array
        #However, within it, there is possibility of have a lower value than the already sorted nums
        #Hence, we need to extend our left and right to include it
        
        lowestSoFar = math.inf
        highestSoFar = -math.inf
        
        for index in range(startPointer, endPointer + 1):
            lowestSoFar = min(lowestSoFar, nums[index])
            highestSoFar = max(highestSoFar, nums[index])
            
        #Now we got our lowest and highest, its time to expand our array boundary
        while startPointer > 0 and nums[startPointer - 1] > lowestSoFar:
            startPointer -=1
            
        while endPointer < len(nums) - 1 and nums[endPointer + 1] < highestSoFar:
            endPointer +=1
            
                    
        return endPointer - startPointer + 1
                    