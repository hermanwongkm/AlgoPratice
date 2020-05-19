/**
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    if(matrix.length === 0){
        return false;
    }
    let row = 0;
    let col = matrix[0].length;
    while(row < matrix.length && col >= 0){
        if(matrix[row][col] === target){
            return true;
        }
        else if(matrix[row][col] < target){ //since the entire row will be smaller than the target also. So get rid of the row.
            row++;  
        }
        else{ //If this value is larger than target, since the entire column will be larger than this value. This whole column is useless
            col--;
        }
    }
    return false;
};
