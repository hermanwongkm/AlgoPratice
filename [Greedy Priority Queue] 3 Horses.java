/**
Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B.

 

Example 1:

Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]

Example 2:

Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]

**/
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int[] ans = new int[A.length];
        Arrays.sort(A);
        int right = A.length -1;
        int left = 0;
        
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){ //If first is > second return positive
                return b[0] - a[0]; //Sort in decending order 
            }
        });
        
        for(int i = 0; i < B.length; i++){
            q.add(new int[] {B[i], i}); //Insert a keyValue pair 
        }
        while(!q.isEmpty()){
            int[] popped = q.poll();
            //always use the highest value
            // Why not the second highest or anything lower? 
            //Because even if i use the second highest, it would not improve anything
            //If the second higher is higher than the current max of B, it will definitely be higher 
            //than any future next values. 
            if(A[right] > popped[0]){
                ans[popped[1]] = A[right];
                right--;
            }
            //So you are trying to minimize loss, if your highest value cant win, just use the lowest. 
            else{
                ans[popped[1]] = A[left];
                left++;
            }
        }
        return ans;
    }
}
