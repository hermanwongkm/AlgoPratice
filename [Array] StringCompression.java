/**
Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.
 

Follow up:
Could you solve it using only O(1) extra space?
 

Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".

 

Example 2:

Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.

**/

class Solution {
    public int compress(char[] chars) {
        int currIndex = 0;
        int indexToPutNumber = 0;
        String ans = "";
        while(currIndex < chars.length){
            char currChar = chars[currIndex];
            int count = 0;
            while(currIndex < chars.length && chars[currIndex] == currChar){
                //This will count 1 by itself 
                count++;
                currIndex++;
            }
            chars[indexToPutNumber] = currChar;
            indexToPutNumber++;
            if(count > 1){
                String s = Integer.toString(count);
                char[] charArray = s.toCharArray();
                for(int i = 0; i < charArray.length; i++){
                    chars[indexToPutNumber] = charArray[i];
                    indexToPutNumber++;
                }
            }
            
        }
        return indexToPutNumber;
    }
}
