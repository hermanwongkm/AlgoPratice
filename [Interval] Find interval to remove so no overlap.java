/**
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 

Example 1:

Input: [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.

Example 2:

Input: [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.

**/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals.length == 0){
            return 0;
        }
        //This is using a greedy approach, you sort it by the earliest end time 
        //Why? by using the earliest time, you are making sure that you can fit as much interval in as possible
        Arrays.sort(intervals, new intervalComparator());
        int end = intervals[0][1];
        int ans = 0;
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < end){ //It means that there's an interval that overlaps with the earliest end time so we need to get rid of it
                ans++;        
            }
            else{ //This interval is okay as it does not overlap so we set it as the new end time
                end = intervals[i][1];
            }
        }
return ans;         
    }
    
    class intervalComparator implements Comparator<int[]> {
         public int compare(int[] a, int[] b) {
             //I want to sort by having smallest end time infront
             //if big minus small, it will return positive, so means a is bigger
             //if small minus big, means negative, means a is smaller
            return a[1] - b[1]; //return 1 if a > b 
        
        }
    }
    
}
