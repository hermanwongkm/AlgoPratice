# You are given an array prices where prices[i] is the price of a given stock on the ith day.

# You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

# Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

# Example 1:

# Input: prices = [7,1,5,3,6,4]
# Output: 5
# Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
# Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        lowestSoFar = prices[0]
        answer = 0
        for i, value in enumerate(prices, 1):
            answer = max(answer, value - lowestSoFar)
            lowestSoFar = min(lowestSoFar, value)
        return answer

#Kadence Solution
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxCur = 0
        maxSoFar = 0;
        for i in range(1,len(prices)):
            #Fundamental idea is that we track our win and loss between the days and add them up
            maxCur += prices[i] - prices[i-1]
            #The reason why we start from 0 if i become negative is because it means i can always dont buy the stock
            maxCur = max(0, maxCur)
            print(maxCur)
            maxSoFar = max(maxCur, maxSoFar)
        return maxSoFar
        


