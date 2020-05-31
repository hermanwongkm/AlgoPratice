/**
The scenario given was finding the divide between "winter" and "summer" given a variable number of monthly temperature readings, 
with the rule that all winter temperatures are lower than all summer temperatures. We can assume that there
is at least one correct partition, and the goal is to get the shortest winter.

 [-5, -1, 5, -42, 6, 12]
**/
import java.util.*;

class Solution {
    public int solution(int[] T) {
    //Winter always start at index 0
    //Max temperature in winter so far
    int maxWinter = T[0]; //When it says maxWinter, it means the highest temperature for winter so far.
    int maxTemp = T[0];
    int ans = 1; 
    for(int i = 0; i < T.length; i++){
        if(T[i] <= maxWinter){
            //Found a new lower value so winter is extended
            ans = i + 1;
            //Since index i is lower than the max, it is also infront of max, so ur maxWinter becomes the max Temp in winter so far
            //The fact that you found a lower temp, means winter is extended. But you should take into consideration the maxTemp so far
            //This will be the maxTemp for winter. And any subsequent value below it is considered winter. 
            maxWinter = maxTemp;
        } 
        else{
            maxTemp = Math.max(maxTemp,T[i]);
        }
    }
    return ans;
    }
}
