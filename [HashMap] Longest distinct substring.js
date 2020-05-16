/**. Longest Substring Without Repeating Characters
Medium

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

 * @param {string} s
 * @return {number}
 */
 //This method uses a hashmap to jump to the position instead of the alternative hashmap method which loops slowly.
 
var lengthOfLongestSubstring = function(s) {
    let startId = 0;
    let ans = 0;
    let map = new Map();
    
    for(let i = 0; i < s.length; i++){
        if(map.get(s.charAt(i)) !== undefined){ //Encountered this char before
            //I want to know whats the length of this substring until here
            ans = Math.max(ans, i - startId);
            if(map.get(s.charAt(i)) >= startId){
            startId = map.get(s.charAt(i)) + 1; //Give it a new starting point
            }
            map.set(s.charAt(i),i); //Update with new index
        }
        else{ //It is a new character
            map.set(s.charAt(i),i);
        } 
    }
    ans = Math.max(ans, s.length - startId); //This is for the case where it is all true
    return ans;
};
