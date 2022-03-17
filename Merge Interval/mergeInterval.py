# Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

# Example 1:

# Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
# Output: [[1,6],[8,10],[15,18]]
# Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

# Example 2:

# Input: intervals = [[1,4],[4,5]]
# Output: [[1,5]]
# Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda array: array[0])
        result = []
        start = intervals[0]
        for i in range(1, len(intervals)):
            print(start)
            #if your front interval's end is larger or equal than next interval's front there's an overlap
            if start[1] >= intervals[i][0]:
                start = [start[0],max(start[1],intervals[i][1])]
            else: #no overlap
                result.append(start)
                start = intervals[i]
        
        result.append(start) #append start to take into consideration the scenarior of [1,4] [4,5]
        return result
                