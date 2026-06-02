class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        List<List<Integer>> res = new ArrayList<>();
        boolean atl[][] = new boolean[grid.length][grid[0].length];
        boolean pac[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            helper(i,0,grid,pac);
            helper(i,grid[0].length-1,grid,atl);
        }
        for(int i = 0;i<grid[0].length;i++){
            helper(0,i,grid,pac);
            helper(grid.length-1,i,grid,atl);
        }
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(pac[i][j] && atl[i][j]) res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }

    public void helper(int r,int c,int grid[][],boolean vis[][]){
        if(vis[r][c]) return;
        vis[r][c] = true;
        int rowdir[] = {-1,0,1,0};
        int coldir[] = {0,1,0,-1};
        for(int i = 0 ;i<4;i++){
            int nr = r + rowdir[i];
            int nc = c + coldir[i];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]>=grid[r][c]){
                helper(nr,nc,grid,vis);
            }
        }
    }
}
