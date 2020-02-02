/**
Let A be a non-empty array consisting of N integers.

The abs sum of two for a pair of indices (P, Q) is the absolute value |A[P] + A[Q]|, for 0 ≤ P ≤ Q < N.

For example, the following array A:

  A[0] =  1
  A[1] =  4
  A[2] = -3
has pairs of indices (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2).
The abs sum of two for the pair (0, 0) is A[0] + A[0] = |1 + 1| = 2.
The abs sum of two for the pair (0, 1) is A[0] + A[1] = |1 + 4| = 5.
The abs sum of two for the pair (0, 2) is A[0] + A[2] = |1 + (−3)| = 2.
The abs sum of two for the pair (1, 1) is A[1] + A[1] = |4 + 4| = 8.
The abs sum of two for the pair (1, 2) is A[1] + A[2] = |4 + (−3)| = 1.
The abs sum of two for the pair (2, 2) is A[2] + A[2] = |(−3) + (−3)| = 6.
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the minimal abs sum of two for any pair of indices in this array.

For example, given the following array A:

  A[0] =  1
  A[1] =  4
  A[2] = -3
the function should return 1, as explained above.

Given array A:

  A[0] = -8
  A[1] =  4
  A[2] =  5
  A[3] =-10
  A[4] =  3
the function should return |(−8) + 5| = 3.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
**/

import java.util.*;

class Solution {
    public int solution(int[] A) {
        //You want to acheive the minimum of absolute
        //So you want to get as close as possible to 0
        //That is done by finding 2 similar negative and positive number
        //But if it is all positive, i want the first 2.
        //But if it is all negative , i want the last 2.
        //It would be first 2, but this question allows repeated value 
        Arrays.sort(A);
        if(A[0] >= 0){ //All positive or zero.
            return A[0] + A[0];
        } 
        else if (A[A.length-1] < 0){ //All negative
            return Math.abs(A[A.length-1] + A[A.length-1]);
        }
        else{
            int min = Integer.MAX_VALUE;
            int start = 0;
            int end = A.length -1;
            while(start < end){
                int sum = A[start] + A[end];
                min = Math.min(min, Math.abs(sum));
                if(sum == 0){
                    return 0; //The lowest possible value
                }
                if(sum < 0){
                    //negative too big
                    start++;
                }
                else{
                    end--;
                }
            }
            return min;
        }
    }
}
