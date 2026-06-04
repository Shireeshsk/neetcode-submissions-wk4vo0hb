class Solution {
    public boolean canFinish(int n, int[][] pre) {
        int indeg[] = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) adj.add(new ArrayList<>());
        for(int sk[] : pre){
            indeg[sk[0]]++;
            adj.get(sk[1]).add(sk[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indeg[i]==0) q.add(i);
        }
        if(q.isEmpty()) return false;
        boolean vis[] = new boolean[n];
        while(!q.isEmpty()){
            int node = q.remove();
            vis[node] = true;
            for(int nei : adj.get(node)){
                indeg[nei]--;
                if(indeg[nei]==0) q.add(nei);
            }
        }
        for(int i =0;i<n;i++){
            if(!vis[i]) return false;
        }
        return true;
    }
}
