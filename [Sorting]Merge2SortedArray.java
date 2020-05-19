class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //The idea is to start from the back and make use of the sorted property
        int a = m - 1;
        int b = n - 1;
        int writeIndex = m + n -1;
        while(a >= 0 && b >= 0){
            if(nums1[a] >= nums2[b]){
                nums1[writeIndex] = nums1[a];
                writeIndex--;
                a--;
            }
            else{
                nums1[writeIndex] = nums2[b];
                writeIndex--;
                b--;
            }
        }
        while(b >= 0){
            nums1[writeIndex] = nums2[b];
            b--;
            writeIndex--;
        }
    }
}
