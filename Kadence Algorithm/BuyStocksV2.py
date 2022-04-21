# You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

# On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

# Find and return the maximum profit you can achieve.

 

# Example 1:

# Input: prices = [7,1,5,3,6,4]
# Output: 7
# Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
# Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
# Total profit is 4 + 3 = 7.

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        continousProfit = 0
        #The idea here is that we track our win and loss between each day and add them up
        #If there is no profit to be made between the day, we don't do anything
        #Else we will add the profit between the day and go to the next.
        for i in range(1, len(prices)):
            if prices[i] > prices[i-1]:
                continousProfit = continousProfit + prices[i] - prices[i-1]
        return continousProfit