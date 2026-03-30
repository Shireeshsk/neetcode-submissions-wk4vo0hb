class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if(!map.containsKey(i)){
                map.put(i,0);
            }
            map.put(i,map.get(i)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return b[1]-a[1];
        });
        for(int i : map.keySet()){
            pq.add(new int[]{i,map.get(i)});
        }
        int res[] = new int[k];
        int idx = 0;
        while(!pq.isEmpty() && idx<res.length){
            int sk[] = pq.remove();
            res[idx++] = sk[0];
        }
        return res;
    }
}
