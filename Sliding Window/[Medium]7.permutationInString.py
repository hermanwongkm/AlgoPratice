# Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

# In other words, return true if one of s1's permutations is the substring of s2.

 

# Example 1:

# Input: s1 = "ab", s2 = "eidbaooo"
# Output: true
# Explanation: s2 contains one permutation of s1 ("ba").

# Example 2:

# Input: s1 = "ab", s2 = "eidboaoo"
# Output: false

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        hashMapMatches = 0 #Keep track of the number of matched char of the pattern
        hashMap = {}
        leftIndex = 0
        
        for i in range(len(s1)):
            char = s1[i]
            if char not in hashMap:
                hashMap[char] = 0
            hashMap[char] += 1
    
        for rightIndex in range (len(s2)):
            rightChar = s2[rightIndex]
            if rightChar in hashMap:
                hashMap[rightChar] -= 1
                if hashMap[rightChar] == 0:
                    hashMapMatches += 1
            
            if hashMapMatches == len(hashMap):
                print(leftIndex)
                print(rightIndex)
                return True
        
        #We can do this because we know that the maximum window length
        #for it to return true, HAS TO BE the length of the pattern
        #>= because if it reaches here, but the same length, means it is not a match
            if rightIndex - leftIndex + 1 >= len(s1):
                leftChar = s2[leftIndex]
                if leftChar in hashMap:
                    if hashMap[leftChar] == 0:
                        hashMapMatches -= 1 
                    hashMap[leftChar] += 1
                leftIndex += 1
        return False
                