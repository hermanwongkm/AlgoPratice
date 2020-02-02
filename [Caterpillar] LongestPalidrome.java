/**
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

**/

//The idea is the loop through each index and expand around the "center" of that index and check if it is a palidrome

class Solution {
    public String longestPalindrome(String s) {
        int start = 0; //This will hold your start and end of ur current longest palidrome 
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            int odd = expandAroundCenter(s,i,i); //The center of the palidrome is odd `bab`
            System.out.println(odd);
            int even = expandAroundCenter(s,i,i+1); //The center of the palidrome is even `baab`
            int len = Math.max(odd,even); //length of palidrome
            if(len > end-start){
                start = i - (len-1)/2;
                end = i + len/2;
            }        
        }
        return s.substring(start,end + 1); //because substring is exclusive
    }
    
    public static int expandAroundCenter(String s,int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s. charAt(end)){
            start--;
            end++;
        }
        return end-start -1 ; //Minus 1 because, if it is true, it will --  & ++ even if the next is invalid 
    }
}
