# Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

# The testcases will be generated such that the answer is unique.

# A substring is a contiguous sequence of characters within the string.

 

# Example 1:

# Input: s = "ADOBECODEBANC", t = "ABC"
# Output: "BANC"
# Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

# Example 2:

# Input: s = "a", t = "a"
# Output: "a"
# Explanation: The entire string s is the minimum window.


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        hashMap = {}
        leftIndex = matched = 0
        minLength = len(s) + 1
        subStringStart = 0
        
        #Populate your hashMap with characters in the pattern
        for char in t:
            if char not in hashMap:
                hashMap[char] = 0
            hashMap[char] += 1
            
        for rightIndex in range(len(s)):
            rightChar = s[rightIndex]
            if rightChar in hashMap:
                hashMap[rightChar] -= 1 #Just allow it to drop below 0, it just means we have a duplicate character
                if hashMap[rightChar] >= 0:
                    matched += 1 #Match only when we have all of the char
                #But we don't want to increment match if i got an duplicate
                #E.g. aa is your pattern aaa is your string
                
            while matched == len(t):
                if minLength > rightIndex - leftIndex + 1:
                    minLength = rightIndex - leftIndex + 1
                    subStringStart = leftIndex
                leftChar = s[leftIndex]
                if leftChar in hashMap:
                    if hashMap[leftChar] == 0: # It means that we finally cross and removed a character in the pattern without anymore nearer duplicate
                        matched -= 1
                    hashMap[leftChar] += 1
                leftIndex += 1
        
        if minLength > len(s):
            return ""
        return s[subStringStart: subStringStart + minLength]
                