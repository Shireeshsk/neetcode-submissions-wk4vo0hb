class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int f = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2) q.add(new int[]{i,j});
                if(grid[i][j]==1) f++;
            }
        }
        int time = 0;
        int rowdir[] = {-1,0,1,0};
        int coldir[] = {0,1,0,-1};
        while(f>0 && !q.isEmpty()){
            int size = q.size();
            for(int k = 0;k<size;k++){
                int sk[] = q.remove();
                for(int i = 0;i<4;i++){
                    int nr = sk[0] + rowdir[i];
                    int nc = sk[1] + coldir[i];
                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                        grid[nr][nc] = 2;
                        f--;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            time++;
        }
        return f==0?time:-1;
    }
}
