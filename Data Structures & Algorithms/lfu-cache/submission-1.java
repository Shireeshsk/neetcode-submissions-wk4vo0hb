class LFUCache {
    int capacity;
    int lfuc;
    Map<Integer,Node> map;
    Map<Integer,DoublyLinkedList> listmap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.lfuc = 0;
        this.map = new HashMap<>();
        this.listmap = new HashMap<>();
    }

    private void counter(Node node){
        int c = node.freq;
        listmap.get(c).pop(node);
        if(c==lfuc && listmap.get(c).length()==0) lfuc++;
        node.freq++;
        if(!listmap.containsKey(node.freq)){
            listmap.put(node.freq,new DoublyLinkedList());
        }
        listmap.get(node.freq).pushRight(node);
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            counter(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            counter(node);
            return;
        }
        if(map.size()==capacity){
            Node toremove = listmap.get(lfuc).popLeft();
            map.remove(toremove.key);
        }
        Node node = new Node(key,value);
        map.put(key,node);
        if(!listmap.containsKey(1)){
            listmap.put(1,new DoublyLinkedList());
        }
        listmap.get(1).pushRight(node);
        lfuc = 1;
    }
}

class Node{
    int key;
    int val;
    int freq;
    Node prev;
    Node next;

    Node(int key,int value){
        this.key = key;
        this.val = value;
        this.next = null;
        this.prev = null;
        this.freq=1;
    }
}

class DoublyLinkedList{
    Node left,right;
    int size;

    DoublyLinkedList(){
        this.left = new Node(-1,-1);
        this.right = new Node(-1,-1);
        this.left.next = this.right;
        this.right.prev = this.left;
        this.size = 0;
    }

    public int length(){
        return size;
    }

    public void pushRight(Node node){
        Node prev = right.prev;
        node.next = right;
        node.prev = prev;
        prev.next = node;
        right.prev = node;
        size++;
    }

    public void pop(Node node){
        Node l = node.prev;
        Node r = node.next;
        l.next = r;
        r.prev = l;
        node.prev = null;
        node.next = null;
        size--;
    }

    public Node popLeft(){
        Node node = left.next;
        pop(node);
        return node;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */