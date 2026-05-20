class Solution {
    public int coinChange(int[] coins, int amount) {

        int dp[][] = new int[coins.length][amount + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        Arrays.sort(coins);

        int ans = helper(coins.length - 1, amount, coins, dp);

        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    public int helper(int idx, int amount, int arr[], int dp[][]) {

        if (amount == 0) return 0;

        if (idx < 0) return Integer.MAX_VALUE;

        if (dp[idx][amount] != -1) return dp[idx][amount];

        int ntake = helper(idx - 1, amount, arr, dp);

        int take = Integer.MAX_VALUE;

        if (arr[idx] <= amount) {

            int temp = helper(idx, amount - arr[idx], arr, dp);

            if (temp != Integer.MAX_VALUE) {
                take = 1 + temp;
            }
        }

        return dp[idx][amount] = Math.min(take, ntake);
    }
}