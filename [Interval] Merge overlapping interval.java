/**
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

**/
//The solution is to sort it by start time. Then, you compare another interval's start time with
//the current end time. If it is less than it, it means its overlaps and you extend your end time if it is greater.

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 1){
            return intervals;
        }
        
        Arrays.sort(intervals, new intervalComparator());
        ArrayList<int []> ans = new ArrayList();
        int[] current = intervals[0];
        ans.add(current);
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= current[1]){ //If the start time is before the current's end time meaning overlap
                current[1] = Math.max(intervals[i][1], current[1]);
            }
            else{ //Non-overlapping
                ans.add(intervals[i]);
                current = intervals[i];
            }    
        }
        return ans.toArray(new int[ans.size()][2]);
    }
    
    class intervalComparator implements Comparator <int[]> {
        public int compare(int[] a, int[] b){
            //sort by start time
            // if its b is larger, it will negative value
            //if a is larger return positive value
            return a[0] - b[0]; 
        }
    }
}
