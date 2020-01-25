

import java.util.*;

class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        //I want to make use of initialize index to let it be 0.
        int[][] array = new int[3][S.length() + 1];
        for(int i = 0; i < S.length(); i++){
            int a = 0; int c = 0; int g = 0;
            if(S.charAt(i) == 'A'){
                a++;
            } 
            else if(S.charAt(i) == 'C'){
                c++;
            }
            else if(S.charAt(i) == 'G'){
                g++;
            }
            // I have to put it here instead of the if statements
            //because i still want to store 0s
            array[0][i + 1] = array[0][i] + a; 
            array[1][i + 1] = array[1][i] + c; 
            array[2][i + 1] = array[2][i] + g; 
        }
        //Now i can start solving it
        int[] answer = new int[P.length]; //initialize answer array
        for(int i = 0; i < P.length; i++){
            int startIndex = P[i];
            int endIndex = Q[i] + 1;
            
            if(array[0][endIndex] - array[0][startIndex] > 0 ){
                answer[i] = 1;
            } 
            else if(array[1][endIndex] - array[1][startIndex] > 0 ){
                answer[i] = 2;
            }
            else if(array[2][endIndex] - array[2][startIndex] > 0 ){
                answer[i] = 3;
            }
            else{
                answer[i] = 4; 
            }
            
        }
        return answer;
    }
}

