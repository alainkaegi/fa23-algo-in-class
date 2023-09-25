package inclass;

public class LinkedSet<K> implements Set<K> {

    /** List element. */
    private class Node {
        K key;
        Node next;

        Node(K key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    /** One end of the list. */
    private Node anchor = null;

    @Override
    public void add(K key) {

    }

    @Override
    public boolean contains(K key) {
        Node n = anchor;
        while (n != null && !n.key.equals(key)) {
            // Invariant: none of the nodes preceding n contained the key
            n = n.next;
        }
        assert n == null || n.key.equals(key);
        return n != null;
    }

    @Override
    public boolean isEmpty() {
        return anchor == null;
    }

    @Override
    public void remove(K key) {

    }
}
