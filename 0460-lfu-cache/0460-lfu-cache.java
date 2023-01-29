class LFUCache {
    HashMap<Integer, LFUNode> keyNodeMap;
    HashMap<Integer, DoublyLinkedList> frequencyListMap;
    int size;
    int capacity;
    int leastFrequency;

    public LFUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.leastFrequency = 1;
        this.keyNodeMap = new HashMap<>();
        this.frequencyListMap = new HashMap<>();
    }

    public int get(int key) {
        if (keyNodeMap.containsKey(key)) {
            LFUNode node = keyNodeMap.get(key);
            updateNode(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyNodeMap.containsKey(key)) {
            LFUNode node = keyNodeMap.get(key);
            node.value = value;
            updateNode(node);
        } else {
            LFUNode newNode = new LFUNode(key, value);
            if (size == capacity) {
                DoublyLinkedList frequencyList = frequencyListMap.get(leastFrequency);
                keyNodeMap.remove(frequencyList.tail.prev.key);
                frequencyList.removeNode(frequencyList.tail.prev);
                size--;
            }
            size++;
            leastFrequency = 1;
            DoublyLinkedList newList = frequencyListMap.getOrDefault(1, new DoublyLinkedList());
            newList.addNode(newNode);
            keyNodeMap.put(key, newNode);
            frequencyListMap.put(1, newList);
        }
    }

    public void updateNode(LFUNode node) {
        DoublyLinkedList frequencyList = frequencyListMap.get(node.frequency);
        frequencyList.removeNode(node);
        if (node.frequency == leastFrequency && frequencyList.size == 0) {
            leastFrequency++;
        }
        DoublyLinkedList nextList = frequencyListMap.getOrDefault(++node.frequency, new DoublyLinkedList());
        nextList.addNode(node);
        frequencyListMap.put(node.frequency, nextList);
    }

}

class DoublyLinkedList {
    LFUNode head;
    LFUNode tail;
    int size;

    public DoublyLinkedList() {
        this.head = new LFUNode(-1, -1);
        this.tail = new LFUNode(-1, -1);
        this.head.next = tail;
        this.head.prev = null;
        this.tail.prev = head;
        this.tail.next = null;
    }

    public void addNode(LFUNode node) {
        size++;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void removeNode(LFUNode node) {
        size--;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}


class LFUNode {
    int key;
    int value;
    int frequency;
    LFUNode next;
    LFUNode prev;

    public LFUNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
