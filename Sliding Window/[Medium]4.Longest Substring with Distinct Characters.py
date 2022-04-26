# Given a string, find the length of the longest substring, which has all distinct characters.

# Example 1:

# Input: String="aabccbb"
# Output: 3
# Explanation: The longest substring with distinct characters is "abc".

# Solution#

# This problem follows the Sliding Window pattern, and we can use a similar dynamic sliding window strategy as discussed in Longest Substring with K Distinct Characters. We can use a HashMap to remember the last index of each character we have processed. Whenever we get a duplicate character, we will shrink our sliding window to ensure that we always have distinct characters in the sliding window.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        slowPointer = 0
        fastPointer = 0
        longestSoFar = 0
        hashMap = {}

        while fastPointer < len(s):
            if s[fastPointer] not in hashMap:
                hashMap[s[fastPointer]] = fastPointer
                longestSoFar = max(longestSoFar, fastPointer - slowPointer + 1)
                fastPointer += 1

            else:
                # Why +1? because if you are taking the right side, the index of the char, we need to move
                # 1 index away from where it is currently situated at.
                slowPointer = max(slowPointer, hashMap[s[fastPointer]] + 1)
                longestSoFar = max(longestSoFar, fastPointer - slowPointer + 1)
                hashMap[s[fastPointer]] = fastPointer
                fastPointer += 1

        return longestSoFar
    # Then if we simplify the top and bottom if else. You will get back the same result

def non_repeat_substring(str1):
  window_start = 0
  max_length = 0
  char_index_map = {}

  # try to extend the range [windowStart, windowEnd]
  for window_end in range(len(str1)):
    right_char = str1[window_end]
    # if the map already contains the 'right_char', shrink the window from the beginning so that
    # we have only one occurrence of 'right_char'
    if right_char in char_index_map:
      # this is tricky; in the current window, we will not have any 'right_char' after its previous index
      # and if 'window_start' is already ahead of the last index of 'right_char', we'll keep 'window_start'
      #What happens here is that we want to shift the start, where we find the position 
      #of the repeated character and go to the next index. 
      #For example, abcdbea, b is repeated, so we get the index of b and increase by 1.
      #The max function, is just so that incase we have a tighter substring.
      window_start = max(window_start, char_index_map[right_char] + 1)
    # insert the 'right_char' into the map
    char_index_map[right_char] = window_end
    # remember the maximum length so far
    max_length = max(max_length, window_end - window_start + 1)
  return max_length


def main():
  print("Length of the longest substring: " + str(non_repeat_substring("aabccbb")))
  print("Length of the longest substring: " + str(non_repeat_substring("abbbb")))
  print("Length of the longest substring: " + str(non_repeat_substring("abccde")))


main()
