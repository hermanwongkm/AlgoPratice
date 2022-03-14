# Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.

# Example 1:

# Input: [-1, 0, 2, 3], target=3 
# Output: 2
# Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]

# Example 2:

# Input: [-1, 4, 2, 1, 3], target=5 
# Output: 4
# Explanation: There are four triplets whose sum is less than the target: 
#    [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]

def triplet_with_smaller_sum(arr, target):
  count = 0
  arr.sort()

  for index, value in enumerate(arr):
    leftIndex = index + 1
    rightIndex = len(arr) - 1
    subTarget = target - value
    while leftIndex < rightIndex:
      if arr[leftIndex] + arr[rightIndex] < subTarget:
        count = count + rightIndex - leftIndex #This will allow you to include all the inbetweens
        leftIndex += 1
      else:
        rightIndex -= 1 
  return count
