class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0,nums,new ArrayList<>(),res);
        return res;
    }
    public void helper(int idx,int arr[],List<Integer> list,List<List<Integer>> res){
        if(idx>=arr.length){
            res.add(new ArrayList<>(list));
            return;
        }
        helper(idx+1,arr,list,res);
        list.add(arr[idx]);
        helper(idx+1,arr,list,res);
        list.remove(list.size()-1);
    }
}
