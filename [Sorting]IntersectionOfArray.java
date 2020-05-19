/**
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

**/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j] && (i == 0 || nums1[i] != nums1[i-1])){
                ans.add(nums1[i]);
                i++;
                j++;
            }
            //the i == 0 is to prevent array out of bound
            else if(nums1[i] < nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        int[] arr = new int[ans.size()];
        for(int k = 0; k < ans.size(); k++){
            arr[k] = ans.get(k);
        }
        return arr;
    }
}
