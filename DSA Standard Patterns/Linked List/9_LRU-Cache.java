class CacheEntry{
    int value;
    long lastAccessTime;
    CacheEntry(int value) {
        this.value = value;
        this.lastAccessTime = System.nanoTime();
    }
}
class LRUCache {
    private int capacity ;
    private Map<Integer, CacheEntry> cache = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
        CacheEntry entry = cache.get(key);
        if (entry == null) return -1;
        entry.lastAccessTime = System.nanoTime();
        return entry.value;
    }
    
    public void put(int key, int value) {
        if (cache.size() >= capacity && !cache.containsKey(key)) {
            // Evict least recently used
            int lruKey = cache.entrySet().stream()
                .min(Comparator.comparingLong(e -> e.getValue().lastAccessTime))
                .map(Map.Entry::getKey)
                .orElse(-1);
            if (lruKey != -1) cache.remove(lruKey);
        }
        cache.put(key, new CacheEntry(value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */



class LRUCache {
    private static class Entry {
        int value;
        int rank;
        Entry(int value, int rank) {
            this.value = value;
            this.rank = rank;
        }
    }

    private Map<Integer, Entry> map;
    private TreeSet<int[]> set; // stores {rank, key}
    private int rank;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.rank = 0;
        this.map = new HashMap<>();
        this.set = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Entry entry = map.get(key);
        int oldRank = entry.rank;
        set.remove(new int[]{oldRank, key});
        rank++;
        set.add(new int[]{rank, key});
        entry.rank = rank;
        return entry.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (set.size() == capacity) {
                int[] oldest = set.first();
                set.remove(oldest);
                map.remove(oldest[1]);
            }
            rank++;
            map.put(key, new Entry(value, rank));
            set.add(new int[]{rank, key});
        } else {
            Entry entry = map.get(key);
            set.remove(new int[]{entry.rank, key});
            rank++;
            entry.value = value;
            entry.rank = rank;
            set.add(new int[]{rank, key});
        }
    }
}


class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // accessOrder = true
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}


class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}