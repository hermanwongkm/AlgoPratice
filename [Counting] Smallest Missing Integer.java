/**
This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
Copyright 2009–2019 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibite **//
    
    import java.util.*;

class Solution {
    public int solution(int[] A) {
        HashSet<Integer> map = new HashSet<Integer>();
        for(int i = 0; i < A.length; i++){
            map.add(A[i]);
        }
        int i = 1;
        while(true){
            if(!map.contains(i)){
                return i;
            }
            i++;
        }
    }
}

import java.util.*;

class Solution {
    public int solution(int[] A) {
        int[] array = new int[A.length];
        
        for(int i : A){
            if(i <= 0 || i > A.length){ //If its negative or too big means it definitely jumped already so you can ignore
                continue;
            }
            array[i-1] = i;
        }
        for(int i = 0; i < array.length; i++){
            if(array[i] != i+1){
                return i + 1;
            }
        }
        return array.length+1;
    }
}

