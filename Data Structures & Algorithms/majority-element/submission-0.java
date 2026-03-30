class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int max = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else{
                map.put(i,1);
            }
            if(max<map.get(i)){
                max = map.get(i);
                res = i;
            }
        }
        return res;
    }
}