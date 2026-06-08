class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for(int sk[] : edges){
            dsu.union(sk[0],sk[1]);
        }
        // List<List<Integer>> adj = new ArrayList<>();
        // boolean vis[] = new boolean[n];
        // for(int i = 0;i<n;i++) adj.add(new ArrayList<>());
        // for(int sk[] : edges){
        //     adj.get(sk[0]).add(sk[1]);
        //     adj.get(sk[1]).add(sk[0]);
        // }
        // int c = 0;
        // for(int i = 0;i<n;i++){
        //     if(!vis[i]){
        //         helper(i,adj,vis);
        //         c++;
        //     }
        // }
        // return c;
        return dsu.count;
    }

    class DSU{
        int parent[];
        int rank[];
        int count;
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            count = n;
            for(int i = 0;i<n;i++) parent[i] = i;
            Arrays.fill(rank,0);
        }

        public int findParent(int n){
            if(parent[n]==n) return n;
            return parent[n]=findParent(parent[n]);
        }

        public void union(int u,int v){
            int pu = findParent(u);
            int pv = findParent(v);
            if(pu==pv) return;
            if(rank[pu]>rank[pv]){
                count--;
                parent[pv] = pu;
            }
            else if(rank[pv]>rank[pu]){
                count--;
                parent[pu] = pv;
            }
            else{
                count--;
                rank[pv]++;
                parent[pu] = pv;
            }
        }
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
