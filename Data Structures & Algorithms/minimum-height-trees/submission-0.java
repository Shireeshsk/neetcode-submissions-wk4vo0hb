class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Arrays.asList(0);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) adj.add(new ArrayList<>());
        for(int sk[] : edges){
            adj.get(sk[0]).add(sk[1]);
            adj.get(sk[1]).add(sk[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int indeg[] = new int[n];
        for(int i = 0;i<n;i++){
            indeg[i] = adj.get(i).size();
            if(indeg[i]==1){
                q.add(i);
            }
        }
        int temp = n;
        while(!q.isEmpty()){
            if(temp<=2) return new ArrayList<>(q);
            int size = q.size();
            for(int i = 0;i<size;i++){
                int node = q.remove();
                temp--;
                for(int nei : adj.get(node)){
                    indeg[nei]--;
                    if(indeg[nei]==1){
                        q.add(nei);
                    }
                }
            }
        }
        return new ArrayList<>();
    }
}