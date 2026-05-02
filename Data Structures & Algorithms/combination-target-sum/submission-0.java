class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0,arr,target,new ArrayList<>(),res);
        return res;
    }

    public void helper(int idx,int arr[],int target,List<Integer> list,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(target<0) return;
        if(idx>=arr.length) return;
        helper(idx+1,arr,target,list,res);
        list.add(arr[idx]);
        helper(idx,arr,target-arr[idx],list,res);
        list.remove(list.size()-1);
    }
}
