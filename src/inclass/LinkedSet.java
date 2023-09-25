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
        for (Node n = anchor; n != null; n = n.next)
            if (n.key.equals(key))
                return true;
        return false;
    }

    @Override
    public boolean isEmpty() {
        return anchor == null;
    }

    @Override
    public void remove(K key) {

    }
}
