/**
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
**/
import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(String S){
    Stack<Character> stack = new Stack<Character>();
    for(int i = 0; i < S.length(); i++){
        if(S.charAt(i) == '{' || S.charAt(i) == '[' || S.charAt(i) == '('){
        stack.push(S.charAt(i));
        }
        else{
            if(stack.empty()){
                return 0;
            }
            else if(S.charAt(i) == '}'){
                char popped = stack.pop();
                if(popped != '{'){
                    return 0;
                }
            }
            else if(S.charAt(i) == ']'){
                char popped = stack.pop();
                if(popped != '['){
                    return 0;
                }                
            }
            else if(S.charAt(i) == ')'){
                char popped = stack.pop();
                if(popped != '('){
                    return 0;
                }                
            }
            
        }
    }
    if(stack.empty()){
     return 1;   
    }
    return 0;
    }
}




import java.util.*;

class Solution {
    public int solution(String S) {
        if(S.length() == 0){
            return 1;
        }
        Stack<Character> stack = new Stack();
        for(int i = 0; i < S.length(); i++){
            char bracket = S.charAt(i);
            if(bracket == '{' || bracket == '(' ||
            bracket == '['){
                stack.push(bracket);
            }else{
                if(stack.isEmpty()){
                    return 0;
                }
                char charComplete = stack.pop();
                String x = ""+charComplete+bracket; //This is a string concat method 
                if(!x.equals("{}") && !x.equals("()") && !x.equals("[]")){ //Note it is && not ||
                    return 0;
                }
            }
            
        }
        if(!stack.isEmpty()){
            return 0;
        }
        return 1;
    }
}

