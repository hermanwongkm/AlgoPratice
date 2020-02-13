/**
 Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100]. 
**/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        //This stack will contain the index of temperature in ascending order only
        Stack<Integer> stack = new Stack();
        //You will loop from the array  T backwards
        //This works because if we encounter a larger number, it does not matter what the previous number were
        //So we just have to keep track of the largest number so far in that sense
        //As we are looping backwards, the current number only cares about the next larger number
        for(int i = T.length -1; i >= 0; i--){
            if(stack.isEmpty() || T[stack.peek()] > T[i]){
                if(!stack.isEmpty()){
                     ans[i] = 1;
                }
                stack.push(i);

               
            }
            else{
                while(!stack.isEmpty() && T[stack.peek()] <= T[i]){
                    stack.pop();
                }
                ans[i] = stack.isEmpty()? 0 : stack.peek() - i;
                stack.push(i);
            }
        }
        return ans;
    }
}
