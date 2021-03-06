/***
You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

Write a function:

class Solution { public int solution(int[] H); }

that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

For example, given array H containing N = 9 integers:

  H[0] = 8    H[1] = 8    H[2] = 5
  H[3] = 7    H[4] = 9    H[5] = 8
  H[6] = 7    H[7] = 4    H[8] = 8
the function should return 7. The figure shows one possible arrangement of seven blocks.



Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array H is an integer within the range [1..1,000,000,000].
***/

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        for(int i = 0; i < H.length; i++){
            if(stack.empty()){
                count++;
                stack.push(H[i]);
                continue;
            }
            int currLevel = stack.peek();
            if(currLevel < H[i]){ //need to add another block to match the height
                count++;
                stack.push(H[i]);
            } 
            else if(currLevel > H[i]){
                while(currLevel > H[i]){ //Pop until you get a less than or same height
                    stack.pop();
                    if(stack.empty() || currLevel == H[i]){
                        break;
                    }
                    currLevel = stack.peek(); //Check current level
                }
                
                if(stack.empty() || currLevel < H[i]){
                    stack.push(H[i]);
                    count++;
                }
            }  
        }
        return count;
        
    }
}

import java.util.*;

class Solution {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack();
        int count = 0;
        int height = 0;
        for(int i = 0; i < H.length; i++){

            while(!stack.isEmpty()){
                if(height == H[i]){
                    break;
                }
                if(height < H[i]){
                    stack.push(H[i] - height);
                    height = H[i];
                    count++;
                    break;
                }
                else{ //Height is higher than the new height
                    height = height - stack.pop();       
                }
            }
            if(stack.isEmpty()){
                stack.push(H[i]);
                count++;
                height = H[i];
                continue;
            }
        }
        return count;
    }
}
