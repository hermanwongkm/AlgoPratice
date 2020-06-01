//Wong Kai Min Herman
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in); 
        int maxCount = 0;
        Map<Integer,Set<Integer>> map = new HashMap();
        while (s.hasNextLine()) {
           String line = s.nextLine();
            if(line.equals("Q1")){
            System.out.println(maxCount);
            } 
            else{
                String[] numArray = line.split("-");
                int firstNum = Integer.parseInt(numArray[0]);
                int secondNum = Integer.parseInt(numArray[1]);
                
                if(map.containsKey(firstNum)){
                    map.get(firstNum).add(secondNum);
                    maxCount = Math.max(maxCount,map.get(firstNum).size());
                }else{
                    Set<Integer> set = new HashSet();
                    set.add(secondNum);
                    map.put(firstNum, set);
                    maxCount = Math.max(maxCount,map.get(firstNum).size());
                    
                }
                
                if(map.containsKey(secondNum)){
                    map.get(secondNum).add(firstNum);
                    maxCount = Math.max(maxCount,map.get(secondNum).size());
                }else{
                    Set<Integer> set = new HashSet();
                    set.add(firstNum);
                    map.put(secondNum, set);
                    maxCount = Math.max(maxCount,map.get(secondNum).size());
                    
                }
           } 
    
        
        }
        
    }
}
