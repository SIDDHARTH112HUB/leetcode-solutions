import java.util.*;

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
