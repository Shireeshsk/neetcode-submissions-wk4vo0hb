class Solution {
    public void setZeroes(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j]==0) q.add(new int[]{i,j});
            }
        }
        while(!q.isEmpty()){
            int sk[] = q.remove();
            helper(sk[0],sk[1],mat);
        }
    }

    public void helper(int r,int c,int mat[][]){
        for(int i = 0;i<mat.length;i++){
            mat[i][c] = 0;
        }
        for(int i = 0;i<mat[0].length;i++){
            mat[r][i] = 0;
        }
    }
}
