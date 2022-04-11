# You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

# Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

# Return intervals after the insertion.

 

# Example 1:

# Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
# Output: [[1,5],[6,9]]

# Example 2:

# Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
# Output: [[1,2],[3,10],[12,16]]
# Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        result = []
        index = 0
        # There will be a few scenarios if its sorted by starting time
        # AAAAAA
        #    BBBBB
        
        # AAAAAAA
        #  BBBBB
        
        # AAAAAA
        #         BBBBB
        #So, we want to skip all the interval that is PURELY infront of this new interval
        # When will that happen? the interval's end must be infront of the next interval's end.
        # Meaning less than the new interval's start
        while index < len(intervals) and intervals[index][1] < newInterval[0]:
            result.append(intervals[index])
            index += 1
            
        #So now, i need to merge this interval 
        # But when do i stop? I will stop when the new interval's end is < the next start
        # This means, you will keep looping as long as it is greater than the interval
        #So that means we can stop merging
        while index < len(intervals) and newInterval[1] >= intervals[index][0]:
            # here, we will keep merging
            newInterval[0] = min(intervals[index][0], newInterval[0])
            newInterval[1] = max(intervals[index][1], newInterval[1])
            index += 1
            
        result.append(newInterval)
        #After this, we have merged everything required and just append the rest
        while index < len(intervals):
            result.append(intervals[index])
            index += 1
        
        return result