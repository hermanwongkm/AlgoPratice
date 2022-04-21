# Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

# Return a list of all possible strings we could create. Return the output in any order.


# Example 1:

# Input: s = "a1b2"
# Output: ["a1b2","a1B2","A1b2","A1B2"]

# Example 2:

# Input: s = "3z4"
# Output: ["3z4","3Z4"]

class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        result = []
        characters = []

        def backTrack(index, characters):
            if(len(characters) == len(s)):
                result.append(''.join(characters))
            else:
                if s[index].isalpha():
                    array = [s[index].lower(), s[index].upper()]
                    for char in array:
                        characters.append(char)
                        backTrack(index + 1, characters)
                        characters.pop()
                else:  # If its a number, once you backtrack. Means you done the rest at the back already
                    # So there's no need to loop or anything.
                    characters.append(s[index])
                    backTrack(index + 1, characters)
                    characters.pop()

        backTrack(0, characters)
        return result
