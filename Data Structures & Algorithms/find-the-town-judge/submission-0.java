class Solution {
    public int findJudge(int n, int[][] trust) {
       List<List<Integer>> adj = new ArrayList<>();
       for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
       }   
       for(int sk[] : trust){
        adj.get(sk[1]-1).add(sk[0]-1);
       }
       for(int i = 0;i<n;i++){
        if(adj.get(i).size()==n-1 && isSafe(i,adj,n) ) return i+1;
       }
       return -1;
    }

    public boolean isSafe(int node,List<List<Integer>> adj ,int n){
        for(int i = 0;i<n;i++){
            if(i!=node){
                for(int j : adj.get(i)){
                    if(j==node) return false;
                }
            }
        }
        return true;
    }
}