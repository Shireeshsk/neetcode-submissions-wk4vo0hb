class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int ans = helper(coins.length-1,amount,coins);
        return ans != Integer.MAX_VALUE?ans:-1;
    }

    public int helper(int idx,int amount,int arr[]){
        if(amount==0) return 0;
        if(idx<0) return Integer.MAX_VALUE;
        int ntake = helper(idx-1,amount,arr);
        int take = Integer.MAX_VALUE;
        if(arr[idx]<=amount){
            int temp =helper(idx,amount-arr[idx],arr);
            if(temp!=Integer.MAX_VALUE){
                take = 1 + temp;
            }
        }
        return Math.min(take,ntake);
    }
}
