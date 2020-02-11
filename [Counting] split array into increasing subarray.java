/**
Given an array nums sorted in ascending order, return true if and only if you can split it into 1 or more subsequences such that each subsequence consists of consecutive integers and has length at least 3.

 

Example 1:

Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5

Example 2:

Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5


**/

class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> created = new HashMap();
        HashMap<Integer,Integer> count = new HashMap();
        
        for(int x : nums){
            count.put(x, count.getOrDefault(x,0) + 1); //If you can get, it defaults to 0 and you just add 1 no matter what
        }
        
        for(int i : nums){
            if(count.get(i) == 0){
                //Does not exist because you might have used it previously already
                continue;
            }
             //The idea is that if you can concat to a existing sequence for a number you will do so.
            if(created.getOrDefault(i,0) > 0){ //If a sequence already exist that allows you to continue you do so
                created.put(i,created.get(i) -1); //Minus away the current sequence because we increased
                created.put(i+1, created.getOrDefault(i+1,0)+1); //We add a new ending for the sequence
            }
            else if(count.getOrDefault(i + 1,0) > 0 && count.getOrDefault(i + 2, 0) > 0){ //If a sequence dont exist, i will create a new sequence
                //You need default for the above as there is a change it does not exist. 
                created.put(i+3, created.getOrDefault(i+3,0)+1);
                count.put(i+1, count.get(i+1) -1);
                count.put(i+2, count.get(i+2) -1);
            }
            
            else{
                return false; //If a sequence dont exist and i cannot create a new sequence it is false
            }
            count.put(i,count.get(i) - 1);
        }
        return true;
    }
}
