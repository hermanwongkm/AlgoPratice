from collections import dequeue


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()
        #Since we need to return all possible permutation, we cannot use an array to store the subset permanently
        #Hence, we will use a queue to store this intermidient state
        queue = deque([[]])
        for i in range(len(nums)):
            # I will loop through the existing subsets
            numberOfSubsets = len(queue)
            for j in range(numberOfSubsets):
                currentSubset = queue.popleft()  # Get the subset
                # now, inside the subset i need to insert this new value at every possible position, INCLUDING last index
                start = 0
                if i > 0 and nums[i] == nums[i-1]:
                    # Find the last index of the element and start from the right of it
                    temp = currentSubset.copy()
                    temp.reverse()
                    start = (len(currentSubset) - temp.index(nums[i]))
                for k in range(start, len(currentSubset) + 1):
                    newSubset = currentSubset.copy()
                    # Insert at the possible positions
                    newSubset.insert(k, nums[i])
                    # this is your answer because all possible permutations are in
                    if len(newSubset) == len(nums):
                        result.append(newSubset)
                    else:  # This is still a intermidient state
                        queue.append(newSubset)
                        print(queue)
        return result
