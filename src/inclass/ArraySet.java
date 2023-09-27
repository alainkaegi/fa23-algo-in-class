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

    }

    private void resize(int newSize) {
        K[] data = (K[])new Object[newSize];
        for (int i = 0; i < size; ++i) {
            data[i] = keys[i];
        }
        keys = data;
    }
}
