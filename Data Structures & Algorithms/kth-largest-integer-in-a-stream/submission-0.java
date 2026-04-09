class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int i : nums) pq.add(i);
    }
    
    public int add(int val) {
        pq.add(val);
        List<Integer> list = new ArrayList<>();
        int res = 0;
        for(int i = 0;i<k && !pq.isEmpty();i++){
            res = pq.remove();
            list.add(res);
        }
        for(int i : list) pq.add(i);
        return res;
    }
}
