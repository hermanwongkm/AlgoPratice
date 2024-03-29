# Given an unsorted array containing numbers, find the smallest missing positive number in it.

# Example 1:

# Input: [-3, 1, 5, 4, 2]
# Output: 3
# Explanation: The smallest missing positive number is '3'

# Example 2:

# Input: [3, -2, 0, 1, 2]
# Output: 4

# Example 3:

# Input: [3, 2, 5, 1]
# Output: 4

def find_first_smallest_missing_positive(nums):
  i, n = 0, len(nums)
  while i < n:
 #The idea is that for a number e.g. 3, it should be at index 2
    j = nums[i] - 1 #j will be the final resting position of this number
      #If the number is larger than my array, i can just ignore it also. As it is not needed
      #For example, imagine you got a number like 10000, then what's the point
      #If its a negative number, we just ignore it 
      # If they are the same, it means it is at the correct position
    if nums[i] > 0 and nums[i] <= n and nums[i] != nums[j]:
      #Swap it to the correct position
      nums[i], nums[j] = nums[j], nums[i]  
    else:
      i += 1

  for i in range(n):
    if nums[i] != i + 1:
      return i + 1

#It will only come here if it is all positive numbers
  return len(nums) + 1


def main():
  print(find_first_smallest_missing_positive([-3, 1, 5, 4, 2]))
  print(find_first_smallest_missing_positive([3, -2, 0, 1, 2]))
  print(find_first_smallest_missing_positive([3, 2, 5, 1]))


main()




# Find the First K Missing Positive Numbers (hard)#

# Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.

# Example 1:

# Input: [3, -1, 4, 5, 5], k=3
# Output: [1, 2, 6]
# Explanation: The smallest missing positive numbers are 1, 2 and 6.

# Example 2:

# Input: [2, 3, 4], k=3
# Output: [1, 5, 6]
# Explanation: The smallest missing positive numbers are 1, 5 and 6.

# Example 3:

# Input: [-2, -3, 4], k=2
# Output: [1, 2]
# Explanation: The smallest missing positive numbers are 1 and 2.

# Solution#

# This problem follows the Cyclic Sort pattern and shares similarities with Find the Smallest Missing Positive Number. The only difference is that, in this problem, we need to find the first ‘k’ missing numbers compared to only the first missing number.

# We will follow a similar approach as discussed in Find the Smallest Missing Positive Number to place the numbers on their correct indices and ignore all numbers that are out of the range of the array. Once we are done with the cyclic sort we will iterate through the array to find indices that do not have the correct numbers.

# If we are not able to find ‘k’ missing numbers from the array, we need to add additional numbers to the output array. To find these additional numbers we will use the length of the array. For example, if the length of the array is 4, the next missing numbers will be 4, 5, 6 and so on. One tricky aspect is that any of these additional numbers could be part of the array. Remember, while sorting, we ignored all numbers that are greater than or equal to the length of the array. So all indices that have the missing numbers could possibly have these additional numbers. To handle this, we must keep track of all numbers from those indices that have missing numbers. Let’s understand this with an example:

#     nums: [2, 1, 3, 6, 5], k =2

# After the cyclic sort our array will look like:

#     nums: [1, 2, 3, 6, 5]

# From the sorted array we can see that the first missing number is ‘4’ (as we have ‘6’ on the fourth index) but to find the second missing number we need to remember that the array does contain ‘6’. Hence, the next missing number is ‘7’.


def find_first_k_missing_positive(nums, k):
  n = len(nums)
  i = 0
  while i < len(nums):
    j = nums[i] - 1
    if nums[i] > 0 and nums[i] <= n and nums[i] != nums[j]:
      nums[i], nums[j] = nums[j], nums[i]  # swap
    else:
      i += 1

  missingNumbers = []
  extraNumbers = set()
  for i in range(n):
    if len(missingNumbers) < k:
      if nums[i] != i + 1:
        missingNumbers.append(i + 1)
        extraNumbers.add(nums[i])

  # add the remaining missing numbers
  i = 1
  while len(missingNumbers) < k:
    candidateNumber = i + n
    # ignore if the array contains the candidate number
    if candidateNumber not in extraNumbers:
      missingNumbers.append(candidateNumber)
    i += 1

  return missingNumbers


def main():
  print(find_first_k_missing_positive([3, -1, 4, 5, 5], 3))
  print(find_first_k_missing_positive([2, 3, 4], 3))
  print(find_first_k_missing_positive([-2, -3, 4], 2))


main()
