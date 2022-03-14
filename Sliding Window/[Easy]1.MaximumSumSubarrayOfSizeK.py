# Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.

# Example 1:

# Input: [2, 1, 5, 1, 3, 2], k=3 
# Output: 9
# Explanation: Subarray with maximum sum is [5, 1, 3].


def max_sub_array_of_size_k(k, arr):
  max_sum = subarray_sum = sum(arr[0:k])
  i = 0

  while i+k < len(arr):
    subarray_sum += arr[i+k] - arr[i]
    i += 1
    if subarray_sum > max_sum:
      max_sum = subarray_sum

  return max_sum
  
  #-------------Solution 2-----------------

def max_sub_array_of_size_k(k, arr):
  currSum = maxSum = start = 0

  for end in range(len(arr)):
    currSum += arr[end]
    
    if end >= k - 1: #This means you hit the maximum size of k 
      maxSum = max(maxSum, currSum)
      currSum -= arr[start] #Shift the start
      start += 1

  return maxSum

