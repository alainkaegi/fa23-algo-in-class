package inclass;

public class HashSet<K> implements Set<K> {

    private K[] keys = (K[])new Object[2];
    private int size = 0;       // excludes tombstones
    private int actualSize = 0; // includes tombstones
    private Object tombstone = new Object();

    private int hash(K key, int sz) {
        return (key.hashCode() & 0x7fffffff)%sz;
    }

    private void insert(int home, K key, K[] keys) {
        assert size < keys.length/2;
        int pos = home;
        while (keys[pos] != null && keys[pos] != tombstone) {
            pos = (pos + 1) % keys.length;
        }
        assert keys[pos] == null || keys[pos] == tombstone;
        keys[pos] = key;
    }

    private int find(int home, K key) {
        int pos = home;
        while (keys[pos] != null && !keys[pos].equals(key)) {
            pos = (pos + 1) % keys.length;
        }
        if (keys[pos] == null) return -1;
        return pos;
    }

    private void resize(int newSize) {
        K[] data = (K[])new Object[newSize];
        for (int i = 0; i < keys.length; ++i) {
            if (keys[i] != null && keys[i] != tombstone) insert(hash(keys[i], data.length), keys[i], data);
        }
        keys = data;
        actualSize = size;
    }

    private void clean() {
        K[] data = (K[])new Object[keys.length];
        for (int i = 0; i < keys.length; ++i) {
            if (keys[i] != null && keys[i] != tombstone) insert(hash(keys[i], data.length), keys[i], data);
        }
        keys = data;
        actualSize = size;
    }

    @Override
    public void add(K key) {
        if (actualSize == keys.length) clean();
        if (size >= keys.length/2) resize(keys.length*2);
        int home = hash(key, keys.length);
        if (find(home, key) != -1) return;
        insert(home, key, keys);
        ++size;
        ++actualSize;
    }

    @Override
    public boolean contains(K key) {
        int home = hash(key, keys.length);
        return find(home, key) != -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(K key) {
        int home = hash(key, keys.length);
        int pos = find(home, key);
        if (pos != -1) {
            keys[pos] = (K)tombstone;
            --size;
        }
    }
}
