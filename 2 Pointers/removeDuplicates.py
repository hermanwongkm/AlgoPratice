# Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the length of the subarray that has no duplicate in it.

# Example 1:

# Input: [2, 3, 3, 3, 6, 9, 9]
# Output: 4
# Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].


def remove_duplicates(arr):
  # index of the next non-duplicate element
  next_non_duplicate = 1

  i = 0
  while(i < len(arr)):
    if arr[next_non_duplicate - 1] != arr[i]:
      arr[next_non_duplicate] = arr[i]
      next_non_duplicate += 1
    i += 1

  return next_non_duplicate



class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        indexToAdd = nextPointer = 1
        
        while nextPointer < len(nums):
            if nums[nextPointer] != nums[nextPointer -1]:
                nums[indexToAdd] = nums[nextPointer]
                indexToAdd += 1
            nextPointer += 1
        
        return indexToAdd
        