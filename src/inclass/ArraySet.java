package inclass;

public class ArraySet<K> implements Set<K> {

    private K[] keys = (K[])new Object[1];
    private int size = 0;

    @Override
    public void add(K key) {
        if (contains(key)) return;
        if (size == keys.length) resize(2*size);
        keys[size++] = key;
    }

    @Override
    public boolean contains(K key) {
        for (int i = 0; i < size; ++i) {
            if (keys[i].equals(key)) return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(K key) {
        for (int i = 0; i < size; ++i) {
            if (keys[i].equals((key))) {
                keys[i] = keys[size - 1];
                keys[size - 1] = null;  // do not keep an unnecessary reference to a deleted object
                --size;
                if (size > 0 && size == keys.length/4) resize(keys.length/2);
                return;
            }
        }
    }

    private void resize(int newSize) {
        K[] data = (K[])new Object[newSize];
        for (int i = 0; i < size; ++i) {
            data[i] = keys[i];
        }
        keys = data;
    }
}
