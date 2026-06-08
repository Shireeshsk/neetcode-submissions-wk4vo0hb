class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean vis[] = new boolean[n];
        for(int i = 0;i<n;i++) adj.add(new ArrayList<>());
        for(int sk[] : edges){
            adj.get(sk[0]).add(sk[1]);
            adj.get(sk[1]).add(sk[0]);
        }
        int c = 0;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                helper(i,adj,vis);
                c++;
            }
        }
        return c;
    }

    public void helper(int node,List<List<Integer>> adj, boolean vis[]){
        vis[node] = true;
        for(int i : adj.get(node)){
            if(!vis[i]){
                helper(i,adj,vis);
            }
        }
    }
}
