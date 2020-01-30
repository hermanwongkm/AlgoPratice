/**
A non-empty array A consisting of N numbers is given. The array is sorted in non-decreasing order. The absolute distinct count of this array is the number of distinct absolute values among the elements of the array.

For example, consider array A such that:

  A[0] = -5
  A[1] = -3
  A[2] = -1
  A[3] =  0
  A[4] =  3
  A[5] =  6
The absolute distinct count of this array is 5, because there are 5 distinct absolute values among the elements of this array, namely 0, 1, 3, 5 and 6.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N numbers, returns absolute distinct count of array A.

For example, given array A such that:

  A[0] = -5
  A[1] = -3
  A[2] = -1
  A[3] =  0
  A[4] =  3
  A[5] =  6
the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647];
array A is sorted in non-decreasing order.
**/

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < A.length; i++){
            set.add(Math.abs(A[i])); //Repeated values will not be added.
        }
        return set.size();
    }
}

class Solution {
    public int solution(int[] A) {
        int start = 0;
        int end = A.length -1;
        int count = 0;
        while(start <= end){
            //this take care of the case when the last 2 are different number 
            if(start == end){
                count++;
                 break;
            }
            //Removing duplicates and the first condition is to avoid out of bound
            if(start != end && A[start] == A[start+1]){
                start++;
                continue;
            }
            if(start !=end && A[end] == A[end-1]){
                end--;
                continue;
            }
            if(A[start] + A[end] == 0){
                start++;
                end--;
                count++;
            }
            else if(A[start] + A[end] < 0){
                count++;
                start++;
            }
            else{
                count++;
                end--;
            }
        }
        //now start and end is the same, so plus 1.
        return count;
    }
}
