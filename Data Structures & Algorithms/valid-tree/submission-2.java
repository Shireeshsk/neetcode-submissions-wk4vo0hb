class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) adj.add(new ArrayList<>());
        for(int sk[] : edges){
            adj.get(sk[0]).add(sk[1]);
            adj.get(sk[1]).add(sk[0]);
        }
        Set<Integer> set = new HashSet<>();
        // boolean vis[] = new boolean[n];
        // for(int i = 0;i<n;i++){
        //     if(!vis[i]){
        //         if(helper(i,adj,-1,vis)) return false;
        //     }
        // }
        if(helper(0,adj,-1,set)) return false;
        return set.size()==n;
    }

    public boolean helper(int node,List<List<Integer>> adj,int par,Set<Integer> set){
        set.add(node);
        for(int nei : adj.get(node)){
            if(!set.contains(nei)){
                if(helper(nei,adj,node,set)) return true;
            }
            else if(nei!=par) return true;
        }
        return false;
    }
}
