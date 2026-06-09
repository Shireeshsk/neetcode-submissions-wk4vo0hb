class Solution {
    public int minimumEffortPath(int[][] grid) {
        int dist[][] = new int[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0});
        dist[0][0] = 0;
        int rowdir[] = {-1,0,1,0};
        int coldir[] = {0,1,0,-1};
        while(!pq.isEmpty()){
            int sk[] = pq.remove();
            int r = sk[0];
            int c = sk[1];
            int wt = sk[2];
            if(r==grid.length-1 && c== grid[0].length-1) return wt;
            if(wt>dist[r][c]) continue;
            for(int i = 0;i<4;i++){
                int nr = r + rowdir[i];
                int nc = c + coldir[i];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length ){
                    int temp = Math.max(wt,Math.abs(grid[r][c]-grid[nr][nc]));
                    if(temp < dist[nr][nc]){
                        dist[nr][nc] = temp;
                        pq.add(new int[]{nr,nc,dist[nr][nc]});
                    }
                }
            }
        }
        return 0;
    }
}