/**
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

Note:

    If there exists a solution, it is guaranteed to be unique.
    Both input arrays are non-empty and have the same length.
    Each element in the input arrays is a non-negative integer.

Example 1:

Input: 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

Output: 3

Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.

**/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for(int i = 0; i < gas.length; i++){
            totalGas = totalGas + gas[i];
            totalCost = totalCost + cost[i];
        }
        //Check if a solution exist or not 
        if(totalGas < totalCost){
            return -1;
        }
        int start = 0;
        int tank = 0;
        //The idea is that if tank + curr is less than zero
        //It means you cant reach here from any of that previous position 
        //Cause it will eventually run out of gas
        //However, a solution is said to exist, thus
        //We can just assume it is at i + 1 which is the next index
        //Which we will then test again.
        //You might say it would not be able to loop around (circle) 
        //but that is okay, because we know a solution definitely exists
        for(int i = 0; i < gas.length; i++){
            int curr = gas[i] - cost[i];
            if(tank + curr < 0){
                tank = 0;
                start = i + 1;
            }
            else{
                tank = tank + curr;
                
            }
        }
        return start;
    }
}
