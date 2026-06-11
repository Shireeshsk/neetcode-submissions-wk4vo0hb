class Solution {
    public boolean exist(char[][] grid, String s) {
        // boolean vis[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length ;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == s.charAt(0)){
                    if(helper(1,i,j,grid,s,new boolean[grid.length][grid[0].length])) return true;
                }   
            }
        }
        return false;
    }

    public boolean helper(int idx,int r,int c,char grid[][],String s,boolean vis[][]){
        if(idx>=s.length()) return true;
        vis[r][c] = true;
        int rowdir[] = {-1,0,1,0};
        int coldir[] = {0,1,0,-1};
        for(int i = 0;i<4;i++){
            int nr = r + rowdir[i];
            int nc = c + coldir[i];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]==s.charAt(idx)){
                if(helper(idx+1,nr,nc,grid,s,vis)) return true;
            }
        }
        vis[r][c] = false;
        return false;
    }
}
