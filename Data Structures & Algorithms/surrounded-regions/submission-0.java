class Solution {
    public void solve(char[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(i==0 || j == 0 || i==grid.length-1 || j==grid[0].length-1){
                    if(grid[i][j]=='O' && !vis[i][j]){
                        helper(i,j,grid,vis);
                    }
                }
            }
        }
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(!vis[i][j] && grid[i][j]=='O'){
                    grid[i][j] = 'X';
                }
            }
        }
    }

    public void helper(int r,int c,char grid[][],boolean vis[][]){
        vis[r][c] = true;
        int rowdir[] = {-1,0,1,0};
        int coldir[] = {0,1,0,-1};
        for(int i = 0;i<4;i++){
            int nr = r + rowdir[i];
            int nc = c + coldir[i];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]=='O'){
                helper(nr,nc,grid,vis);
            }
        }
    }
}
