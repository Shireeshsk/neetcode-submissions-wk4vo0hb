class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        for(int sk[] : edges){
            if(dsu.union(sk[0],sk[1])) return sk;
        }
        return new int[]{0,0};
    }

    class DSU{
        int parent[];
        int rank[];

        DSU(int n){
            parent = new int[n+1];
            rank = new int[n+1];
            for(int i = 0;i<=n;i++){
                parent[i] = i;
            }
            Arrays.fill(rank,0);
        }
        public int findParent(int n){
            if(parent[n]==n) return n;
            return parent[n] = findParent(parent[n]);
        }
        
        public boolean union(int u,int v){
            int pu = findParent(u);
            int pv = findParent(v);
            if(pu==pv) return true;
            if(rank[pu]>rank[pv]){
                parent[pv] = pu;
            }
            else if(rank[pv]>rank[pu]){
                parent[pu] = pv;
            }
            else{
                rank[pv]++;
                parent[pu] = pv;
            }
            return false;
        }
    }
}
