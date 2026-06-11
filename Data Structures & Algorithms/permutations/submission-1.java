class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        boolean vis[] = new boolean[arr.length];
        helper(0,arr,new ArrayList<>(),res,vis);
        return res;
    }

    public void helper(int s,int arr[],List<Integer> list,List<List<Integer>> res , boolean vis[]){
        if(s>=arr.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i<arr.length;i++){
            if(vis[i]) continue;
            vis[i] = true;
            list.add(arr[i]);
            helper(s+1,arr,list,res,vis);
            list.remove(list.size()-1);
            vis[i] = false;
        }
    }
}
