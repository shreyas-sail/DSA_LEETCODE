class Solution {
    public void setZeroes(int[][] matrix) {
        Boolean rowHasZero = false;
        Boolean colHasZero = false;
        for(int i = 0;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                    colHasZero = true;
                    break;
                }
        }
        
        for(int j = 0;j<matrix[0].length;j++){
                if(matrix[0][j] == 0){
                    rowHasZero = true;
                    break;
                }
            }
        // System.out.println(colHasZero);
        // System.out.println(rowHasZero);
        for(int i = 1;i<matrix.length;i++){
            for(int j = 1;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1;i<matrix.length;i++){
            for(int j = 1;j<matrix[0].length;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(rowHasZero){
            for(int j = 0;j<matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }
        if(colHasZero){
            for(int i = 0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
    }
}