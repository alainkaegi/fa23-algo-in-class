package inclass;

/** A set of keys. */
public interface Set<K> {

    /** Adds key to this set. Has no effect if key is already in this set. */
    public void add(K key);

    /** Returns true if this set contains key. */
    public boolean contains(K key);

    /** Returns true if this set is empty. */
    public boolean isEmpty();

    /** Removes key from this set if it is present. */
    public void remove(K key);

}
