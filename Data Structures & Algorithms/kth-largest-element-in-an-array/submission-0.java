class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int i : nums) pq.add(i);
        for(int i = 0;i<k-1 &&!pq.isEmpty();i++){
            pq.remove();
        }
        return pq.peek();
    }
}
