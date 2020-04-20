/**
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
**/

class Solution {
    public int maxArea(int[] height) {
        //The idea uses 2 pointers
        //It basically moves the pointers towards each other and hopefully you can get 2 taller lines so you can have a greater volume
        int maxVolume = 0;
        int left = 0;
        int right = height.length - 1;
        
        while(left < right){
            int volume = Math.min(height[left], height[right]) * (right - left);
            maxVolume = Math.max(volume,maxVolume);
            if(height[left] < height[right]){
                left++; //Move because you hope the next one will be taller so you can contain more water
            }
            else{
                right--;
            }
        }
        return maxVolume; 
    }
}
