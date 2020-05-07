Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]


class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isColumn = false;
        
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){ //Check that the first column is actually to be set to 0
                isColumn = true; 
            }
            for(int j = 1; j < matrix[0].length; j++){ //start from column 1 as column 0 is already taken care of above
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0; //Setting whatever row's first column to be 0
                    matrix[0][j] = 0; //Setting the first entry of this column to be 0
                }
            }
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){ //Now looping through each element and checking its row and column if it is 0
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0; //set the entire first row to be 0
            }    
        }
        if(isColumn){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
