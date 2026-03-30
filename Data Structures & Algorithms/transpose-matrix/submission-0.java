class Solution {
    public int[][] transpose(int[][] mat) {
        int res[][] = new int[mat[0].length][mat.length];
        for(int i = 0;i<res.length;i++){
            for(int j = 0;j<res[0].length;j++){
                res[i][j] = mat[j][i];
            }
        }
        return res;
    }
}