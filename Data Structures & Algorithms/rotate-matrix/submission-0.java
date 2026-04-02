class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        helper(matrix);
    }
    public void helper(int mat[][]){
        int j = mat[0].length-1;
        int i = 0;
        while(i<j){
            for(int k = 0;k<mat.length;k++){
                int temp = mat[k][i];
                mat[k][i] = mat[k][j];
                mat[k][j] = temp;
            }
            i++;
            j--;
        } 
    }
    public void transpose(int mat[][]){
        for(int i = 0;i<mat.length;i++){
            for(int j = i+1;j<mat[0].length;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
}
