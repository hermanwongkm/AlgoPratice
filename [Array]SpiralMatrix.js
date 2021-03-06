/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function(matrix) {
    ans = [];
    if(matrix.length === 0){
        return ans;
    }

    let r1 = 0;
    let r2 = matrix.length - 1;
    let c1 = 0;
    let c2 = matrix[0].length -1;
    
    while(r1 <= r2 && c1 <= c2){
        //Now i want to move across the columns
        for(let i = c1; i <= c2; i++){ //<= because i want to include the whole row
            ans.push(matrix[r1][i]);
        }
        //Now i want to move down
        for(let j = r1+1; j <= r2; j++){ //+1 because the previous one took up the first value in this column
            ans.push(matrix[j][c2]); //c2 because last column
        }
        if(r1 < r2 && c1 < c2){//this is for the case of [[3],[2]]
            

        //Now i want to move left
        for(let i = c2-1; i > c1; i--){ //The previous one took up the value of this row and it is > but not >= because it does not include the last value
            ans.push(matrix[r2][i]);
        }
        //Now i want to move up
        for(let j = r2; j > r1; j--){ //Same as above, where it does not include the last value.
            ans.push(matrix[j][c1]);
        }
        }
        //Now that we conquered an outer layer time to move in the corners
        r1++;
        r2--;
        c1++;
        c2--;
    }
    return ans;
};
