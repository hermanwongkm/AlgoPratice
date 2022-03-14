# Problem Statement#

# Given a string, find the length of the longest substring in it with no more than K distinct characters.

# Example 1:

# Input: String="araaci", K=2
# Output: 4
# Explanation: The longest substring with no more than '2' distinct characters is "araa".

# Example 2:

# Input: String="araaci", K=1
# Output: 2
# Explanation: The longest substring with no more than '1' distinct characters is "aa".


#Solution 2
def longest_substring_with_k_distinct(str1, k):
  hashMap = {}
  maxLength = start = 0
  for end in range(len(str1)):
    character = str1[end]
    if character not in hashMap:
      hashMap.update({character: 1}) # same as hashMap[charater] = 1
    else:
      hashMap[character] += 1

    while len(hashMap) > k:
      startChar = str1[start]
      hashMap[startChar] -= 1
      if hashMap[startChar] == 0:
        del hashMap[startChar]
      start += 1

    maxLength = max(maxLength, end - start  + 1)
  return maxLength



#solution 1 
def longest_substring_with_k_distinct(str1, k):
  char_counts = { str1[0]: 1 }
  i = j = 0
  max_len = 1

  while i < len(str1):
    if len(char_counts) <= k:
      max_len = max(max_len, j - i + 1)

    if len(char_counts) <= k and j < len(str1) - 1:
      max_len = max(max_len, j - i + 1)
      j += 1
      if str1[j] not in char_counts:
        char_counts[str1[j]] = 0
      char_counts[str1[j]] += 1
    else:
      char_counts[str1[i]] -= 1
      if char_counts[str1[i]] == 0:
        del char_counts[str1[i]]
      i += 1

  return max_len


