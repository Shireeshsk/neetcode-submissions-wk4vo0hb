class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] query) {
        int indeg[] = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) adj.add(new ArrayList<>());
        for(int sk[] : pre){
            indeg[sk[1]]++;
            adj.get(sk[0]).add(sk[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0) q.add(i);
        }
        Set<Integer> hash[] = new HashSet[n];
        for(int i = 0;i<n;i++){
            hash[i] = new HashSet<>();
        }
        while(!q.isEmpty()){
            int sk = q.remove();
            for(int i : adj.get(sk)){
                hash[i].add(sk);
                hash[i].addAll(hash[sk]);
                indeg[i]--;
                if(indeg[i]==0) q.add(i);
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int sk[] : query){
            res.add(hash[sk[1]].contains(sk[0]));
        }
        return res;
    }
}