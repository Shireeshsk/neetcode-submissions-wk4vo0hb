class Solution {
    public List<List<Integer>> permuteUnique(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        boolean vis[] = new boolean[arr.length];
        helper(0,arr,new ArrayList<>(),res,vis,new StringBuilder(),new HashSet<>());
        return res;
    }

    public void helper(int s,int arr[],List<Integer> list,List<List<Integer>> res,boolean vis[],StringBuilder sb,Set<String> set){
        if(s>=arr.length){
            if(!set.contains(sb.toString())){
                res.add(new ArrayList<>(list));
            }
            set.add(sb.toString());
            return;
        }
        for(int i = 0;i<arr.length;i++){
            if(vis[i]) continue;
            sb.append(arr[i]);
            list.add(arr[i]);
            vis[i] = true;
            helper(s+1,arr,list,res,vis,sb,set);
            vis[i] = false;
            list.remove(list.size()-1);
            sb.setLength(sb.length()-1);
        }
    }
}