/**
 You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number
**/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //Use the stack to hold values until you meet something greater than the curr/rest
        //Once you met something greater, you found the next greater for this number and the prev ones
        //So you put them into a map for o(1) retrival for nums1
        Stack<Integer> stack = new Stack();
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                //So if its less than it means you found the next greater
                int popped = stack.pop();
                map.put(popped,nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            ans[i] =(map.getOrDefault(nums1[i],-1));
        }
        return ans;
    }
}
