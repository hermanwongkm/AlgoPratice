// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        TreeSet<Integer> set = new TreeSet();
        for(int x : A){
            set.add(x);
        }
        Iterator<Integer> itr =  set.iterator();
        int count = 1;
        while(itr.hasNext()){
            int val = itr.next();
            if(val <= 0){
                continue;
            } 
            else if (val != count){
                return count;
            }
            count++;
        }
    if(set.last() <= 0){
        return 1;
    }
    return set.last() + 1;    
    }
}
