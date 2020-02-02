/**
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321

**/

class Solution {
    public int reverse(int x) {
        long result = 0;
        boolean isNegative = false;
        if(x<0){
            isNegative = true;
        }
        x = Math.abs(x);
        while(x != 0){
            result = (result*10) + (x%10);
            if(result > Integer.MAX_VALUE) return 0;
            if(result < Integer.MIN_VALUE) return 0;
            x = x/10;
        }

        if(isNegative){
            return (int)result * -1;
        }
        return (int)result;
    }
}
