class Solution {
    public int maxProfit(int[] arr) {
        int profit = Integer.MIN_VALUE;
        int curr = arr[0];
        for(int i : arr){
            profit = Math.max(profit,i-curr);
            curr = Math.min(curr,i);
        }
        return profit;
    }
}
