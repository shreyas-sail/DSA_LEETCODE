class LRUCache {
    Node head;
    Node tail;
    int capacity ;
    Map<Integer,Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            insert(n);
            return n.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
    
    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insert(Node node){
        map.put(node.key,node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }
    
    
}

class Node{
        int val,key;
        Node next;
        Node prev;
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */