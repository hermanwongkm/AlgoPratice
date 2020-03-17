/**
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
**/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, 999); //Fill the array up so we can save the minimum
        memo[0] = 0; //Minimum number of coin for amount $0 
        
        for(int i = 1;i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                //First part so it will not minus too much and go out of bound
                //Next, remember that memo[i] = 999 at the start
                //And, you have solved the sub-problem of the smallest required coins for memo[i - coin[j]]
                //Why do you do the i - coin[j]? Well, it is like saying
                //As the coin value increases, you are saying you can replace this amount of coin with 1 coin thus the +1
                if(coins[j] <= i && memo[i - coins[j]] + 1 < memo[i]){ 
                    memo[i] = memo[i - coins[j]] + 1;
                }
            }
        }
        if(memo[amount] == 999){
            return -1;
        }
        return memo[amount];
    }
}
