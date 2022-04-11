# You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

# Return the intersection of these two interval lists.

# A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

# The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        indexA = indexB = 0
        result = []
        while indexA < len(firstList) and indexB < len(secondList):
            #if a overlaps b
            #    aaaaa
            #  bbbb
            # First part is like sorting it
            # Second part, how do i definitely confirm that it overlaps? Well, if the start is infront of the end
            #Do the same for the other side
            if (firstList[indexA][0] >= secondList[indexB][0] and firstList[indexA][0] <= secondList[indexB][1]) or \
                (secondList[indexB][0] >= firstList[indexA][0] and secondList[indexB][0] <= firstList[indexA][1]):
                #So if either of it overlaps we will try to extract it out
                result.append([max(firstList[indexA][0], secondList[indexB][0]), 
                              min(firstList[indexA][1], secondList[indexB][1])])
                
            if firstList[indexA][1] > secondList[indexB][1]:
                indexB += 1
            else:
                indexA += 1
        return result   