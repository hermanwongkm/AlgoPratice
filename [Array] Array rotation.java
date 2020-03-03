/**
 shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:

    class Solution { public int[] solution(int[] A, int K); }

that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given
    A = [3, 8, 9, 7, 6]
    K = 3

the function should return [9, 7, 6, 3, 8]. Three rotations were made:
    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]

For another example, given
    A = [0, 0, 0]
    K = 1

the function should return [0, 0, 0]

Given
    A = [1, 2, 3, 4]
    K = 4

the function should return [1, 2, 3, 4]
**/

//This solution is O(N)
//Get the modulus, whic his like taking away the number of times it repeats

class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if(A.length == 0){
            int arr[] = new int[0];
            return arr;
        }
        int rotation = K%A.length;
        int[] ans = new int[A.length];
        for(int i = 0; i < A.length; i ++){
            ans[((i+rotation) % A.length)] = A[i];
        }
        return ans;
    }
}

Approach #4 Using Reverse [Accepted]

Algorithm

This approach is based on the fact that when we rotate the array k times, kk%nk elements from the back end of the array come to the front and the rest of the elements from the front shift backwards.

In this approach, we firstly reverse all the elements of the array. Then, reversing the first k elements followed by reversing the rest n−kn-kn−k elements gives us the required result.

Let n=7n=7n=7 and k=3k=3k=3.

Original List                   : 1 2 3 4 5 6 7
After reversing all numbers     : 7 6 5 4 3 2 1
After reversing first k numbers : 5 6 7 4 3 2 1
After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result

java

public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}


//Rotate left in javascript
//I noticed that for example length is 5 and you rotate by 4. You move backwards by 4. but you also move forward by 1.
function rotLeft(a, d) {
    var rotation = d%a.length;
    var ans = [];

    var i;
    for(i = 0; i < a.length; i++){
        ans[(i + (a.length - rotation)) % a.length] = a[i]; 
    }
    return ans;

}

