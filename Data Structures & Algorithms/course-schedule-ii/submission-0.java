class Solution {
    public int[] findOrder(int n, int[][] pre) {
        int indeg[] = new int[n];
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<n;i++) res.add(new ArrayList<>());
        for(int sk[] : pre){
            indeg[sk[0]]++;
            res.get(sk[1]).add(sk[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indeg[i]==0) q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int sk = q.remove();
            ans.add(sk);
            for(int nei : res.get(sk)){
                indeg[nei]--;
                if(indeg[nei]==0) q.add(nei);
            }
        }
        if(ans.size()!=n) return new int[]{};
        int result[] = new int[n];
        for(int i = 0;i<n;i++){
            result[i] = ans.get(i);
        }
        return result;
    }
}
