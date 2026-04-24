import java.util.*;

class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> temp = map.get(key);
        if (temp == null) return "";
        Map.Entry<Integer, String> entry = temp.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
