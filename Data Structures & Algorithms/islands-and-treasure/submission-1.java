class Solution {
    static int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==0) q.add(new int[]{i,j});
            }
        }   
        int rowDir[] = {-1,0,1,0};
        int colDir[] = {0,-1,0,1};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + rowDir[i];
                int nc = c + colDir[i];

                if (nr >= 0 && nr < grid.length &&
                    nc >= 0 && nc < grid[0].length &&
                    grid[nr][nc] == INF) {

                    grid[nr][nc] = grid[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
