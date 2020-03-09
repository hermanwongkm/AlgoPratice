class Solution {
    public int compress(char[] chars) {
        int currIndex = 0;

        while(currIndex < chars.length){
            char currChar = chars[currIndex];
            int count = 0;
            while(currIndex < chars.length && chars[currIndex] == currChar){
                //This will count 1 by itself 
                count++;
                currIndex++;
            }
        }
        
    }
}
