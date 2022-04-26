
# Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

#     Integers in each row are sorted from left to right.
#     The first integer of each row is greater than the last integer of the previous row.


# Example 1:

# Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
# Output: true

# For a zero-based index, the two operations are, where width is the width of the structure:

# row    = index / width
# column = index % width

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        length = len(matrix[0]) * len(matrix)
        left = 0
        right = length - 1

        while left <= right:
            middle = int(left + (right - left)/2)
            rowIndex = int(middle / len(matrix[0]))
            columnIndex = int(middle % len(matrix[0]))
            value = matrix[rowIndex][columnIndex]
            if target == value:
                return True
            elif value < target:
                left = middle + 1
            else:
                right = middle - 1

        return False
