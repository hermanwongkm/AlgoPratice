/**
You are given integers K, M and a non-empty array A consisting of N integers. Every element of the array is not greater than M.

You should divide this array into K blocks of consecutive elements. The size of the block is any integer between 0 and N. Every element of the array should belong to some block.

The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.

The large sum is the maximal sum of any block.

For example, you are given integers K = 3, M = 5 and array A such that:
  A[0] = 2
  A[1] = 1
  A[2] = 5
  A[3] = 1
  A[4] = 2
  A[5] = 2
  A[6] = 2

The array can be divided, for example, into the following blocks:

        [2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
        [2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
        [2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
        [2, 1], [5, 1], [2, 2, 2] with a large sum of 6.

The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.
**/

import java.util.*;

//Trying to use binary search to search for a large sum value
//You do this based on the max and minimum possible value of it
class Solution {
    public int solution(int K, int M, int[] A) {
        int lowest = max(A);
        int largest = sum(A);
        int ans = 0;
        
        while(lowest <= largest){
            int mid = (lowest + largest)/2;
            int numOfBlocks = calculateNumberOfBlocksIflargestIsMid(A,mid);
            if(numOfBlocks <= K){
                //This means that i can have more blocks thus spreading out more value reducing largest sum
                largest = mid -1;
                ans = mid;
            }
            else if(numOfBlocks > K){
                //I have too many blocks, means my mid value is too small, so i have to increase my value
                lowest = mid + 1;
                
            }
     
        }
    return ans;
    }
    
    //This method is greedy, meaning that it will just count until you cant fit anymore into the block then add another block
    public int calculateNumberOfBlocksIflargestIsMid(int[]A, int mid){
        int numOfBlocks = 1;
        int currCount = 0;
        for(int i : A){
            currCount = currCount + i;
            if(currCount > mid){
                currCount = i;
                numOfBlocks++;
            }
        }
        return numOfBlocks;
    }    
    //No inbuild function for these
     private static int sum(int[] input) {
    int sum = 0;
    for (int n : input) {
      sum += n;
    }
    return sum;
  }
  
      private static int max(int[] input) {
    int max = -1;
    for (int n : input) {
      if (n > max) {
        max = n;
      }
    }
    return max;
  }
}
