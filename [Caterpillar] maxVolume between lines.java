/**
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
**/
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;
        int maxVolume = 0;
        while(left < right){
            maxVolume = Math.max(maxVolume,(right - left) * (Math.min(height[left], height[right])));
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
