class TimeMap {
    // A custom pair to hold the data
    class Data {
        int timestamp;
        String value;
        Data(int ts, String val) {
            this.timestamp = ts;
            this.value = val;
        }
    }

    Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Data(timestamp, value));
    }
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        
        List<Data> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        String res = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (list.get(mid).timestamp <= timestamp) {
                // This is a potential candidate! 
                // Save it and look to the right for a larger timestamp that still fits.
                res = list.get(mid).value;
                left = mid + 1;
            } else {
                // Too large, search left
                right = mid - 1;
            }
        }
        
        return res;
    }
}