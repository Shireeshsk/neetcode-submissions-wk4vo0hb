class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,candidates,target,new ArrayList<>(),res);
        return res;
    }
    public void helper(int idx,int arr[],int target,List<Integer> list,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(target<0 || idx>=arr.length) return;
        int temp = idx;
        while(temp+1<arr.length && arr[temp]==arr[temp+1]) temp++;
        helper(temp+1,arr,target,list,res);
        if(target-arr[idx]>=0){
            list.add(arr[idx]);
            helper(idx+1,arr,target-arr[idx],list,res);
            list.remove(list.size()-1);
        }
    }
}
