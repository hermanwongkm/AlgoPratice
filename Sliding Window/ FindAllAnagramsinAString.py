# Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

# An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

# Example 1:

# Input: s = "cbaebabacd", p = "abc"
# Output: [0,6]
# Explanation:
# The substring with start index = 0 is "cba", which is an anagram of "abc".
# The substring with start index = 6 is "bac", which is an anagram of "abc".

# Example 2:

# Input: s = "abab", p = "ab"
# Output: [0,1,2]
# Explanation:
# The substring with start index = 0 is "ab", which is an anagram of "ab".
# The substring with start index = 1 is "ba", which is an anagram of "ab".
# The substring with start index = 2 is "ab", which is an anagram of "ab".

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hashMap = {}
        leftIndex = matched = 0
        result = []
        for char in p:
            if char not in hashMap:
                hashMap[char] = 0
            hashMap[char] += 1
            
        
        for rightIndex in range(len(s)):
            rightChar = s[rightIndex]
            if rightChar in hashMap:
                hashMap[rightChar] -= 1
                if hashMap[rightChar] == 0:
                    matched += 1
            
            if matched == len(hashMap):
                result.append(leftIndex)
            #Basically we will always be moving the right index to the right
            #and the left index is also constantly moving
            #so alternatively, you can do 
            #if window_end >= len(pattern) - 1:
            if rightIndex - leftIndex + 1 >= len(p):
                leftChar = s[leftIndex]
                if leftChar in hashMap:
                    if hashMap[leftChar] == 0:
                        matched -=1
                    hashMap[leftChar] += 1
                leftIndex += 1
                
        return result
                
                
            