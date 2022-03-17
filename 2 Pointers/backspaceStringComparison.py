# Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

# Note that after backspacing an empty text, the text will continue empty.

 

# Example 1:

# Input: s = "ab#c", t = "ad#c"
# Output: true
# Explanation: Both s and t become "ac".

# Example 2:

# Input: s = "ab##", t = "c#d#"
# Output: true
# Explanation: Both s and t become "".

class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        #I want to loop through both at the same time
        s1Index = len(s) - 1
        s2Index = len(t) - 1
        while s1Index >= 0 or s2Index >= 0:
            s1 = self.getCharIndex(s1Index, s)
            s2 = self.getCharIndex(s2Index, t)
            if s[s1] != t[s2]:
                return False
            if s1 < 0 and s2 < 0:
                return True
            if s1 < 0 or s2 < 0: #The only scenario this happens if the function backspaces all the way
                #But if both backspaces all the way, then it is equal. Which is resolved above
                return False 
            
            s1Index = s1 - 1
            s2Index = s2 - 1
            
        return True
    
    def getCharIndex(self, index, array):
        backspaceCount = 0
        while index >= 0:
            if array[index] == '#':
                backspaceCount += 1
            #If it comes here, means it is a letter
            elif backspaceCount > 0:
                backspaceCount -= 1 #This means that there's backspace
            else:
                break
            index -= 1
        return index
            

            
            