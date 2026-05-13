 class MyHashMap {

    int[] map;

    public MyHashMap() {
        map = new int[1000001];   // max key constraint is 10^6
        Arrays.fill(map, -1);     // -1 means key doesn't exist
    }

    public void put(int key, int value) {
        map[key] = value;         // directly store value at index key
    }

    public int get(int key) {
        return map[key];          // returns -1 if key doesn't exist
    }

    public void remove(int key) {
        map[key] = -1;            // reset back to -1 means removed
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */