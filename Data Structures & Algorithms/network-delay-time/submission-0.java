class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++) adj.add(new ArrayList<>());
        for(int sk[] : times){
            int u = sk[0];
            int v = sk[1];
            int wt = sk[2];
            adj.get(u).add(new int[]{v,wt});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{k,0});
        dist[k]=0;
        while(!pq.isEmpty()){
            int sk[] = pq.remove();
            int node = sk[0];
            int curr = sk[1];
            if(curr>dist[node]) continue;
            for(int nei[]:adj.get(node)){
                if(curr+nei[1]<dist[nei[0]]){
                    dist[nei[0]] = curr+nei[1];
                    pq.add(new int[]{nei[0],dist[nei[0]]});
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans = Math.max(ans,dist[i]);
        }
        return ans;
    }
}
