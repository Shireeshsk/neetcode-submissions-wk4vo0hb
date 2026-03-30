class Solution {
    public int subsetXORSum(int[] nums) {
        int res[] = {0};
        helper(0,nums,0,res);
        return res[0];
    }
    public void helper(int idx,int arr[],int xor,int res[]){
        if(idx==arr.length){
            res[0]+=xor;
            return;
        }
        helper(idx+1,arr,xor,res);
        helper(idx+1,arr,xor^arr[idx],res);
    }
}