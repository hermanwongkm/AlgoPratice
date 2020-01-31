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
import java.util.*;

class Solution {
    public int solution(int[] A) {
    //By sorting the array, we have guaranteed that P+R > Q and Q+R > P (because R is always the biggest).
    //Now what remains, is the proof that P+Q > R, that can be found out by traversing the array
        Arrays.sort(A);
        int count = 0;
        //Fix the first pointer
        for(int i = 0; i < A.length -2; i++){
            //fix third pointer, but want it to be independent ofsecond pointer loop
            int k = i + 2;
            //Fix the second pointer
            for(int j = i +1; j < A.length-1; j++){
                //loop through the third pointer to find the max it can go for first and second index
                while(k < A.length && A[i] + A[j] > A[k]){
                    k++;
                }
                //The above while loop will not run once you found the max for k and thus, the next line will just run immediately, counting the number of triangles able to be formed till here with a fixed i.
                count = count + k-j-1; // you always have an extra k++ then it stops that why you need a -1
                 // for every i and j we figure out the maximal k that can be a
                // triangular, and when we increase j the former k would still
                // be a triangular because of the sorted array, so we just need
                // to count the number of triangular between j and k.
            }
        }
        return count;
    }
}

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

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
