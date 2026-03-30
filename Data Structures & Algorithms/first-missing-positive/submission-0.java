class Solution {
    public int firstMissingPositive(int[] nums) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            min = Math.min(min,i);
            max = Math.max(max,i);
            map.put(i,0);
        }
        if(max<0) return 1;
        for(int i = 1;i<=max;i++){
            if(!map.containsKey(i)) return i;
        }
        return max+1;
    }
}