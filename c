/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        boolean numeric = input.matches("-?\\d+(\\.\\d+)?");
        if(numeric){
        String ans = helper(Integer.parseInt(input));
        if(ans.length() < 1){
            System.out.println("Invalid Input");
        }
        else{
        ans = ans.substring(0,1).toUpperCase() + ans.substring(1) + " only";
        System.out.println(ans);           
        }
        }
        else{
            System.out.println("Error occurred");
        }



        
    }
    public static String helper(int input){
        
        String[] ones = {"", "one", "two", "three","four","five","six","seven", "eight",               "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

           String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",            "eighty", "ninety"};

            String ans = "";
           if(input < 20){
               ans = ones[input];
           }
           else if(input < 100){
               if(input % 10 == 0){
                    ans = ans + tens[input/10];
               }
                else{
                    ans = ans + tens[input/10] + " " + ones[input %10];
                }
           }
           else if(input < 1000){
               if(input %100 == 0){
                   ans = ones[input/100] + " hundred";
               }
               else{
               ans = ones[input/100] + " hundred " + "and " + helper(input %100); 
                }
           }
           else if(input < 100000){
               ans = helper(input/1000) + " thousand";
               if(input % 1000 > 99){
                   ans = ans + ", ";
                   ans = ans + helper(input %1000);
               } 
               else if( input % 1000 == 0){
                   return ans;
               }
               else{
                   ans = ans + " and " + helper(input%1000);
               }
           }
           return ans;

    }
}
