class Solution {
    public int lastStoneWeight(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int i : arr) pq.add(i);
        while(pq.size()>1){
            int a = pq.remove();
            int b = pq.remove();
            int res = Math.abs(a-b);
            if(res!=0) pq.add(res);
        }
        return pq.isEmpty()?0:pq.peek();
    }
}
