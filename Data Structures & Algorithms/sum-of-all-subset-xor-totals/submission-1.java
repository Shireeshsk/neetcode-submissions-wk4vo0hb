class Solution {
    public int subsetXORSum(int[] nums) {
        int sum[] ={0};
        helper(0,nums,sum,0);
        return sum[0];
    }
    public void helper(int idx,int arr[],int sum[],int curr){
        if(idx>=arr.length){
            sum[0] += curr;
            return;
        }
        helper(idx+1,arr,sum,curr);
        helper(idx+1,arr,sum,curr^arr[idx]);
    }
}