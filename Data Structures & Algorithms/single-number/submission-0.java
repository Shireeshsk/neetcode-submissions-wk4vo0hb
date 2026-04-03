class Solution {
    public int singleNumber(int[] nums) {
        int temp = 0;
        for(int i : nums){
            temp ^= i;
        }
        return temp;
    }
}
