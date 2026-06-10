class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1,n,k,new ArrayList<>(),res);
        return res;
    }
    public void helper(int idx,int n,int k,List<Integer> list ,List<List<Integer>> res){
        if(k==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(k<0 || idx>n) return;
        helper(idx+1,n,k,list,res);
        list.add(idx);
        helper(idx+1,n,k-1,list,res);
        list.remove(list.size()-1);
    }
}