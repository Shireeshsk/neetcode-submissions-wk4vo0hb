class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            int diff = Math.abs(a - x) - Math.abs(b - x);
            if (diff == 0) return a - b;
            return diff;
        });
        for(int i : arr) pq.add(i);
        List<Integer> res = new ArrayList<>();
        int idx = Math.min(k,arr.length);
        while(idx>0){
            res.add(pq.remove());
            idx--;
        }
        Collections.sort(res);
        return res;
    }
}