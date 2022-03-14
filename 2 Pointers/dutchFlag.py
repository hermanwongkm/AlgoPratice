# Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

# We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

# You must solve this problem without using the library's sort function.

 

# Example 1:

# Input: nums = [2,0,2,1,1,0]
# Output: [0,0,1,1,2,2]

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        zeroIndex = movingIndex = 0
        twoIndex = len(nums) - 1
        
        while movingIndex <= twoIndex: 
            #why <=? Because imagine 2,0,1. We need to investigate it even if TwoIndex was shifted back
            if nums[movingIndex] == 0:
                nums[movingIndex] = nums[zeroIndex]
                nums[zeroIndex] = 0
                zeroIndex += 1
                movingIndex += 1 # why?
                #The idea is that if it is a `1` at the low index then it would be fine.
                #And it is not possible for it to be a `2`.
                #Imagine if its a 2 swap with a 2. at the start Middle would not have moved. like 2,2,...2,2
                #It would eventually resolve itself with all the 2s at the back.
                #Then if its a 1 swap. It is okay, we will swap with middle eventually would would be ok with 1.
            elif nums[movingIndex] == 1: 
                movingIndex += 1 #it is where it is, so we can increment it
            else: 
                nums[movingIndex] = nums[twoIndex]
                #Swap with movingIndex, but we have yet to process it yet
                #So there's no increment of movingIndex
                nums[twoIndex] = 2
                print(nums)
                twoIndex -= 1
                
                
                
                
        