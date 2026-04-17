class Solution {
    public int numIslands(char[][] grid) {
        int c = 0;
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    helper(i,j,grid,vis);
                    c++;
                }
            }
        }
        return c;
    }
    public void helper(int row,int col,char grid[][],boolean vis[][]){
        vis[row][col] = true;
        int rowdir[] = {-1,0,1,0};
        int coldir[] = {0,1,0,-1};
        for(int i = 0;i<4;i++){
            int nr = row + rowdir[i];
            int nc = col + coldir[i];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]=='1'){
                helper(nr,nc,grid,vis);
            }
        }
    }
}
