/**
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

**/

//Record the maximum profit possible in an array in the first forward pass.
//Next, you do a backward pass and compute the max profit backwards.
//Then, you can add the current profit + the max profit from the previous days possible. 
var maxProfit = function(prices) {
    let firstArray = []
    let minPrice = Number.MAX_VALUE
    let maxProfitSoFar = 0
    
    //this is the same as buy and sell stock 1
    //It records the maximum profit possible so far at this point
    for(let i = 0; i < prices.length; i++){
        minPrice = Math.min(minPrice, prices[i])
        maxProfitSoFar = Math.max(maxProfitSoFar, prices[i] - minPrice)
        firstArray.push(maxProfitSoFar)
    }
    //Now, the second loop backwards calculate the same thing but backwards.
    //Then, you add with the previous array but -1 from the index, as you cannot buy and sell on the same day.
    let maxPrice = Number.MIN_VALUE
    for(let i = prices.length -1; i > 0; i--){
        maxPrice = Math.max(prices[i], maxPrice)
        maxProfitSoFar = Math.max(maxProfitSoFar, maxPrice - prices[i] + firstArray[i-1])
    }
    return maxProfitSoFar
    
};
