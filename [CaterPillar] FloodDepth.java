/**
FloodDepth
Find the maximum depth of water in mountains after a huge rainfall.
Task description
You are helping a geologist friend investigate an area with mountain lakes. A recent heavy rainfall has flooded these lakes and their water levels have reached the highest possible point. Your friend is interested to know the maximum depth in the deepest part of these lakes.
We simplify the problem in 2-D dimensions. The whole landscape can be divided into small blocks and described by an array A of length N. Each element of A is the altitude of the rock floor of a block (i.e. the height of this block when there is no water at all). After the rainfall, all the low-lying areas (i.e. blocks that have higher blocks on both sides) are holding as much water as possible. You would like to know the maximum depth of water after this entire area is flooded. You can assume that the altitude outside this area is zero and the outside area can accommodate infinite amount of water.
For example, consider array A such that:
A[0] = 1
A[1] = 3
A[2] = 2
A[3] = 1
A[4] = 2
A[5] = 1
A[6] = 5
A[7] = 3
A[8] = 3
A[9] = 4
A[10] = 2
The following picture illustrates the landscape after it has flooded:
The gray area is the rock floor described by the array A above and the blue area with dashed lines represents the water filling the low-lying areas with maximum possible volume. Thus, blocks 3 and 5 have a water depth of 2 while blocks 2, 4, 7 and 8 have a water depth of 1. Therefore, the maximum water depth of this area is 2.
Write a function:
int solution(vector<int> &A);
that, given a non-empty zero-indexed array A consisting of N integers, returns the maximum depth of water.
Given array A shown above, the function should return 2, as explained above.
For the following array:
A[0] = 5
A[1] = 8
the function should return 0, because this landscape cannot hold any water.
Assume that:
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..100,000,000].
Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

**/

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
public static int solution(int[] A) {
    // The idea is to have a pointer on the left & right end
    // Loop through by moving either point towards each other
    // You will move the pointer that is less than the other.
    // By doing so, you ensure that the other wall is definitely higher than your
    // current wall
    // Thus, you can just use the current wall minus away the deepest point for the
    // depth.
    // This will always be the depth because this wall is always shorter than the
    // one on the right.
    int start = 0;
    int end = A.length - 1;
    int ans = 0;
    int maxHeightLeft = 0, maxHeightRight = 0;

    while (start < end) {
      if (A[start] <= A[end]) {
        // Try to get the maximum depth
        maxHeightLeft = Math.max(maxHeightLeft, A[start]);
        ans = Math.max(ans, maxHeightLeft - A[start]);
        start++;
        // The fact that you had a previous wall, means the right side is still higher
        // So the water can still be collected in this area
        // You also dont have to be afraid that it returns negative or same height -
        // same height as you max with 0
      } 
      else {
        maxHeightRight = Math.max(maxHeightRight, A[end]);
        ans = Math.max(ans, maxHeightRight - A[end]);
        end--;
      }
    }
    return ans;
  }

    //The idea is that you traverse from left to right first. Now, you know the maximum you can get.
    //However, what you dont know is there is a wall on the right side that will hold the water/
    //So now, you loop through from right to left and for each index, you will take the minimum.
    //This way, you will ensure that there is a wall on the right. 
    int solution(vector<int> &A) {
    int n = A.size(), res = 0;
    vector<int> depths(n);
    int wall = A[0];
    for(int i=1; i<n-1; ++i)
    {
        if(A[i] > wall) wall = A[i];
        else depths[i] = wall - A[i];
    }
    
    wall = A[n-1];
    for(int i= n-2; i>0; --i)
    {
        if(A[i] > wall) 
        {
            wall = A[i];
            depths[i] = 0;
        }
        else depths[i] = min(wall-A[i], depths[i]);
        
        res = max(res, depths[i]);
    }
    return res;
}
