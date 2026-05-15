class Solution {
    public int maxSubArray(int[] nums) {
        int csum = 0;
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            if(csum<0){
                csum = 0;
            }
            csum += i;
            max = Math.max(max,csum);
        }
        return max;
    }
}
