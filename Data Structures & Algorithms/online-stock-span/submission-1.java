class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int val) {
        int idx = 1;
        while(!st.isEmpty() && st.peek()[0]<=val){
            idx += st.pop()[1];
        }
        st.push(new int[]{val,idx});
        return idx;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */