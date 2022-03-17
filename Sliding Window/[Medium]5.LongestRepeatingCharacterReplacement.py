# You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

# Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

# Example 1:

# Input: s = "ABAB", k = 2
# Output: 4
# Explanation: Replace the two 'A's with two 'B's or vice versa.

# Example 2:

# Input: s = "AABABBA", k = 1
# Output: 4
# Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
# The substring "BBBB" has the longest repeating letters, which is 4.


class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        hashMap = {}
        maxFrequency = 0
        leftIndex = 0
        maxLength = 0
        
        for rightIndex in range(len(s)):
            rightChar = s[rightIndex]
            if rightChar not in hashMap:
                hashMap[rightChar] = 0
            hashMap[rightChar] += 1
            maxFrequency = max(maxFrequency, hashMap[rightChar])
            
            if rightIndex - leftIndex + 1 - maxFrequency > k:
                leftChar = s[leftIndex]
                hashMap[leftChar] -= 1
                leftIndex += 1
                #You might think, you need to update the maxFrequency here
                #However, you if you do that, you are incurring an addition O(26)
                #As you need to scan through all the alphabets to get the maxFreq again
                #This is based on the principal that the result(maxLength),
                #is only going to be maximized IF we find a NEW maxFrequency.
                #We are doing - maxFrequency, hence we want to maximize it
                #Therefore,even if it decreases to 3 from 4.
                #It is NOT going to change our result
                #I may be overestimating it at this given point, but it doesn't matter
                #As we would require our maxFrequency to increase and we need it to change
                # https://www.youtube.com/watch?v=gqXU1UyA8pk   
            maxLength = max(maxLength, rightIndex - leftIndex + 1)
        return maxLength