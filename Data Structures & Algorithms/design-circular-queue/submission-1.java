class MyCircularQueue {
    ListNode head;
    ListNode tail;
    int size;
    int max;
    public MyCircularQueue(int k) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.max = k;
    }
    
    public boolean enQueue(int value) {
        if(size==max) return false;
        if(head==null){
            head = new ListNode(value);
            head.next = head;
            tail = head;
            size++;
            return true;
        }
        size++;
        ListNode temp = tail;
        temp.next = new ListNode(value);
        temp.next.next = head;
        tail = temp.next;
        return true;
    }
    
    public boolean deQueue() {
        if(size==0) return false;
        if(head==tail){
            head=null;
            tail=null;
            size--;
            return true;
        }
        size--;
        head = head.next;
        tail.next = head;
        return true;
    }
    
    public int Front() {
        if(head==null) return -1;
        return head.val;
    }
    
    public int Rear() {
        if(tail==null) return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==max;        
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(){
        this.next = null;
    }
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */