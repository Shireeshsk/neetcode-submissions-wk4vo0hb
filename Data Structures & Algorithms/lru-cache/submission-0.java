class LRUCache {
    Map<Integer,ListNode> map;
    int max;
    ListNode head;
    ListNode tail;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.max = capacity;
        this.head = new ListNode(-1,-1);
        this.tail = new ListNode(-1,-1);
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        ListNode newN = new ListNode(key,value);
        map.put(key,newN);
        insert(newN);
        if(map.size()>max){
            ListNode lru = this.tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }

    public void remove(ListNode node){
        ListNode ptemp = node.prev;
        ListNode ntemp = node.next;
        ptemp.next = ntemp;
        ntemp.prev = ptemp;
    }

    public void insert(ListNode node){
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }
}

class ListNode{
    int val;
    int key;
    ListNode next;
    ListNode prev;

    ListNode(){
        this.next = null;
        this.prev = null;
    }

    ListNode(int key,int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
} 
