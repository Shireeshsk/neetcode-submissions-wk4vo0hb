class Solution {
    public int majorityElement(int[] nums) {
        int c = 0;
        int can = 0;
        for(int i : nums){
            if(c == 0){
                can = i;
            }
            if(can==i){
                c++;
            }
            else c--;
        }
        return can;
    }
}