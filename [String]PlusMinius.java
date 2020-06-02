import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(int N) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 1; i < N; i = i + 2){
            sb.append("+-");
        }
        if(N % 2 == 1){
            sb.append("+");
        }
        return sb.toString();
    }
}
