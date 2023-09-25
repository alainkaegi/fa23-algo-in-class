package inclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySetTest {

    Set<Integer> s = new ArraySet<>();

    @Test
    void isInitiallyEmpty() {
        assertTrue(s.isEmpty());
    }

    @Test
    void isNotEmptyAfterAdd() {
        s.add(1);
        assertFalse(s.isEmpty());
    }

    @Test
    void remembersAddedKey() {
        s.add(1);
        assertTrue(s.contains(1));
    }

    @Test
    void removesKey() {
        s.add(1);
        s.remove(1);
        assertFalse(s.contains(1));
    }

    @Test
    void doesNotRemoveOtherKey() {
        s.add(1);
        s.add(2);
        s.remove(2);
        assertTrue(s.contains(1));
    }

    @Test
    void becomesEmptyAtCorrectTime() {
        s.add(1);
        s.add(2);
        s.remove(1);
        assertFalse(s.isEmpty());
        s.remove(2);
        assertTrue(s.isEmpty());
    }

    @Test
    void doesNotStoreDuplicates() {
        s.add(1);
        s.add(1);
        s.remove(1);
        assertTrue(s.isEmpty());
    }

}