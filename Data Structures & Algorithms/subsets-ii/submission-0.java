class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(0,nums,new ArrayList<>(),res);
        return res;
    }
    public void helper(int idx,int arr[],List<Integer> list,List<List<Integer>> res){
        if(idx>=arr.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[idx]);
        helper(idx+1,arr,list,res);
        list.remove(list.size()-1);
        int temp = idx;
        while(temp+1<arr.length && arr[temp]==arr[temp+1]) temp++;
        helper(temp+1,arr,list,res);
    }
}
