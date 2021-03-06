/**
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

**/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();
        int start = 0;
        int end = 0;
        int max = 0;
        while(start < s.length() && end < s.length()){
            if(set.contains(s.charAt(end))){
                set.remove(s.charAt(start));
                start++;
            }
            else{
                set.add(s.charAt(end));
                end++;
                max = Math.max(max,end-start);
            }
        }
        return max;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int front = 0;
        int back = 0;
        int ans = 0;
        int count = 0;
        HashSet<Character> set = new HashSet();
        
        while(front < s.length() && back < s.length()){
            if(!set.contains(s.charAt(back))){
                set.add(s.charAt(back));
                count++;
                back++;
            }
            else{ //If it contains it already
                set.remove(s.charAt(front));
                front++;
                count--;
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }
}
