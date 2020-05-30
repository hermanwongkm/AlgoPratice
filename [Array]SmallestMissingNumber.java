/**


An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

    class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:
  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5

the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..100,000];
        the elements of A are all distinct;
        each element of array A is an integer within the range [1..(N + 1)].
        
**/

//Save the number into their correct respective index and do swapping
class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length == 1 && nums[0] != 0){
            return 0;
        }
        
        int i = 0;
        while(i < nums.length){
            //if number at index number (but shift by 1) not equals to curr number
            if(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] -1] != nums[i]){
                //Perform swap
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
            else{
                i++;
            }
        }

        for(i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return 0;
    }
}


// you can also use imports, for example:
import java.util.*;


class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length == 0){
            return 1;
        }
        Arrays.sort(A);
        for(int i = 0; i < A.length; i++){
            if(i+1!=A[i]){
                return i+1;
            }
        }
        return A[A.length-1]+1;
    }
}
