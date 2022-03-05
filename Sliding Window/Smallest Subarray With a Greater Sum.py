# Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.

# Example 1:

# Input: [2, 1, 5, 2, 3, 2], S=7 
# Output: 2
# Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].

import math 

def smallest_subarray_sum(s, arr):
  start = 0
  end = 0
  sum = 0
  minLength = math.inf

  for end in range(len(arr)):
    sum += arr[end]

    while sum >= s:
      minLength = min(minLength, end - start + 1)
      sum -= arr[start]
      start += 1

  return minLength
