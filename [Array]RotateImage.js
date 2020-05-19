var rotate = function(matrix) {
    var len = matrix.length;
    for (let i = 0; i < Math.floor(len / 2); i++) {
        for (let j = 0; j < len - Math.floor(len / 2); j++){
                up = matrix[i][j];
                right = matrix[j][len - i - 1];
                down = matrix[len - i - 1][len - j - 1];
                left = matrix[len - j - 1][i];
                tmp = up;
                matrix[i][j] = left;
                matrix[len - j - 1][i] = down;
                matrix[len - i - 1][len - j - 1] = right;
                matrix[j][len - i - 1] = tmp;
            }
        }
};
