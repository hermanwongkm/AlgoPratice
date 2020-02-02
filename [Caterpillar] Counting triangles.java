/**
An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if it is possible to build a triangle with sides of lengths A[P], A[Q] and A[R]. In other words, triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
For example, consider array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 12
There are four triangular triplets that can be constructed from elements of this array, namely (0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the number of triangular triplets in this array.

For example, given array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 12
the function should return 4, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..1,000];
each element of array A is an integer within the range [1..1,000,000,000].

**/
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int count = 0; 
        //Sort the array first so you only need to compare P + Q > R. 
        //Since it is sorted, R plus anything will always be larger
        Arrays.sort(A);
        //Now you loop through first index
        //minus 2 because that's as far as it gets to make a triangle
        for(int i = 0; i < A.length -2; i++){
            //Loop through second index
            //However, instead of having another loop for the third index
            //The idea is that if it is a triangle for the current indexes,
            //It will also be a valid triangle for the future indexes, so you dont have to recheck
            int k = i + 2; 
            //Imagine a scenario, [10, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
            //Index 1 = 10, index 2 = 15. K would reach all the way to end of array
            //Now, index 1 = 10, index 2 = 16. K is still at the end. You dont have to
            //recalculate so it is faster 
            for(int j = i + 1; j < A.length - 1; j++){
                while(k < A.length && A[i] + A[j] > A[k]){
                    //Try to find the max k for the triangle as it is sorted, you can break once
                    //it is not fulfilled as the others will also not be valid
                    k++;
                }
                //Now, once you broke out, means you found the max triangle
                //However, because k = i + 2, if you use k - j, it will always be 1 ahead
                //even if it is not valid. So you need to minus.
                count = count + k - j - 1; //k - j counts the number of triangle inbetween 
            
                
            }
        }
        return count;
    }
}



import java.util.*;

class Solution {
    public int solution(int[] A) {
        int count =0;
        Arrays.sort(A);
        //If the array is sorted, P+R > Q and Q+R >P will automatically be true 
        for(int i = 0; i < A.length - 2; i++){
            for(int j = i +1; j < A.length - 1; j++){
                int k = j + 1;
                while(k < A.length && A[i] + A[j] > A[k]){
                    k++;
                }
                count = count + (k-j)-1;
            }
        }
        return count;
    }
}
