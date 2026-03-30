class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();   
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() { 
        // if(q.size()==1) return q.remove();
        int size = q.size()-1;
        while(size>0){
            int temp = q.remove();
            q.add(temp);
            size--;
        }
        return q.remove();
    }
    
    public int top() {
        // if(q.size()==1) return q.peek();
        int size = q.size()-1;
        while(size>0){
            int temp = q.remove();
            q.add(temp);
            size--;
        }
        int top = q.peek();
        q.add(q.remove());
        return top;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */