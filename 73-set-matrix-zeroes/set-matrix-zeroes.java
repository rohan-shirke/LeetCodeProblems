class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean rowZero = false;
        boolean colZero = false;

        // Check if the first row should be zeroed
        for(int i=0; i<n; i++){
            if(matrix[0][i] == 0){
                rowZero = true;
                break;
            }
        }

        // Check if the first column should be zeroed
        for(int i=0; i<m; i++){
            if(matrix[i][0] == 0){
                colZero = true;
                break;
            }
        }

        // Use the first row and first column to mark rows and columns to be zeroed
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Zero out rows and columns based on the markers
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(rowZero){
            for(int j = 0; j<n; j++){
                matrix[0][j] = 0;
            }
        }

        if(colZero){
            for(int j = 0; j<m; j++){
                matrix[j][0] = 0;
            }
        }
    }
}