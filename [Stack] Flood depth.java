/**
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
**/

class Solution {
    public int trap(int[] height) {
        //Always do edge case first
        if(height.length < 2){
            return 0; //Cannot contain water with 2 blocks
        }
        Stack<Integer> stack = new Stack();
        int volume = 0;
        int i = 0;
        while(i < height.length){ 
            if(stack.isEmpty()|| height[i] <= height[stack.peek()]){ //Push when it's shorter
                stack.push(i);
                i++;
            } //This guy is taller and you will keep coming until you meet something taller
            else{
                int previous = stack.pop(); //Get the previous one out
                //Now, the previous one is definitely taller than the 'previous' that's why it was pushed
                //So you can calculate the water depth for this block at this level
                if(!stack.isEmpty()){
                    int maxHeight = Math.min(height[i],height[stack.peek()]); //Find the lower of the height of the walls to calculate maximum depth
                    volume = volume + (maxHeight - height[previous]) * (i- stack.peek() -1); //Even if its more than 2 blocks away, it is considered of
                    //the "same levle" since you already did maxHeight - height[previous]
                }
            }
        }
        return volume;
        
    }
}
