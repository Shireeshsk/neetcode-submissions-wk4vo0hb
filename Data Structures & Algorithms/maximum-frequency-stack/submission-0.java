class FreqStack {
    Map<Integer,Integer> map;
    PriorityQueue<int[]> pq;   
    int idx;
    public FreqStack() {
        map = new HashMap<>();
        pq = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return b[2]-a[2];
            else return b[1]-a[1];
        });
        idx = 0;
    }
    
    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        pq.add(new int[]{val,map.get(val),idx});
        idx++;
    }
    
    public int pop() {
        int[] sk = pq.poll();
        map.put(sk[0],map.get(sk[0])-1);
        return sk[0];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */