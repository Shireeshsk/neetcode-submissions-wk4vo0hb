class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    int c[] = {0};
                    helper(i,j,grid,vis,c);
                    max = Math.max(max,c[0]);
                }
            }
        }
        return max;
    }
    private void helper(int row,int col,int grid[][],boolean vis[][],int c[]){
        vis[row][col] = true;
        c[0]++;
        int rowdir[] = {-1,0,1,0};
        int coldir[] = {0,1,0,-1};
        for(int i = 0;i<4;i++){
            int nr = row + rowdir[i];
            int nc = col + coldir[i];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]==1){
                helper(nr,nc,grid,vis,c);
            }
        }
    }
}
