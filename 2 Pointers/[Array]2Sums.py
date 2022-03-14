# Given an array of integers, return indices of the two numbers such that they add up to a specific target.

# You may assume that each input would have exactly one solution, and you may not use the same element twice.

# Example:

# Given nums = [2, 7, 11, 15], target = 9,

# Because nums[0] + nums[1] = 2 + 7 = 9,
# return [0, 1].

# //This solution is O(N)
# * First initialize a hashMap.
# * Loop through the array, and check what is the other number you are looking for, for each index
# * Check if this value exist in the hashmap
# * If it does, you return, else you add the current index into it.
# * You can do this method as if you had encounter its pair it would have been in the hashMap already.
# 

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashMap = {}
        for i, value in enumerate(nums):
            remainder = target - value
            if remainder in hashMap:
                return [hashMap[remainder], i]
            else:
                hashMap[value] = i
        

#If it is already sorted, we can do the below method:
def pair_with_targetsum(arr, target_sum):
  left, right = 0, len(arr) - 1
  while(left < right):
    current_sum = arr[left] + arr[right]
    if current_sum == target_sum:
      return [left, right]

    if target_sum > current_sum:
      left += 1  # we need a pair with a bigger sum
    else:
      right -= 1  # we need a pair with a smaller sum
  return [-1, -1]

