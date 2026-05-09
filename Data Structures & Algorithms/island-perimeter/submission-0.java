class Solution {
    public int islandPerimeter(int[][] grid) {
        int per[] ={0};
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    helper(i,j,grid,vis,per);
                }
            }
        }
        return per[0];
    }

    public void helper(int i,int j,int grid[][],boolean vis[][],int peri[]){
        vis[i][j] = true;
        peri[0] += 4;
        int rowdir[] = {-1,0,1,0};
        int coldir[] = {0,1,0,-1};
        for(int k = 0;k<4;k++){
            int nr = i + rowdir[k];
            int nc = j + coldir[k];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                peri[0] -=1;
                if(!vis[nr][nc]){
                    helper(nr,nc,grid,vis,peri);
                }
            }
        }
    }
}