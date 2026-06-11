class LRUCache {
    ListNode head;
    ListNode tail;
    Map<Integer,ListNode> map;
    int size;
    public LRUCache(int capacity) {
        this.size = capacity;
        this.head = new ListNode(-1,-1);
        this.tail =  new ListNode(-1,-1);
        this.map = new HashMap<>();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void remove(ListNode node){
        ListNode l = node.prev;
        ListNode r = node.next;
        l.next = r;
        r.prev = l;
    }
    
    public void insert(ListNode node){
        ListNode prevh = head.next;
        node.next = prevh;
        node.prev = head;
        prevh.prev = node;
        head.next = node;
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
        ListNode node = new ListNode(key,value);
        map.put(key,node);
        insert(node);
        if(map.size()>size){
            ListNode temp = tail.prev;
            remove(temp);
            map.remove(temp.key);
        }
    }
}

class ListNode{
    int key;
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int key,int value){
        this.key = key;
        this.val = value;
        this.next = null;
        this.prev = null;
    }
}
