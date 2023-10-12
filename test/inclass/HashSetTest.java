package inclass;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HashSetTest {

    Set<Integer> s = new HashSet<>();

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

    @Test
    void handlesManyItems() {
        Set<String> s1 = new HashSet<>();
        String[] words = {
                "A", "a", "aa", "aal", "aalii",
                "aam", "Aani", "aardvark", "aardwolf", "Aaron",
                "Aaronic", "Aaronical", "Aaronite", "Aaronitic", "Aaru",
                "Ab", "aba", "Ababdeh", "Ababua", "abac",
                "abaca", "abacate", "abacay"
        };
        for (int i = 0; i < words.length; ++i) {
            s1.add(words[i]);
            // After each addition, check all words for membership
            for (int j = 0; j < words.length; ++j) {
                if (j <= i) assertTrue(s1.contains(words[j]));
                else        assertFalse(s1.contains(words[j]));
            }
        }
    }

    @Test
    void handlesManyItemsWithDeletion() {
        Set<String> s1 = new HashSet<>();
        String[] words = {
                "A", "a", "aa", "aal", "aalii",
                "aam", "Aani", "aardvark", "aardwolf", "Aaron",
                "Aaronic", "Aaronical", "Aaronite", "Aaronitic", "Aaru",
                "Ab", "aba", "Ababdeh", "Ababua", "abac",
                "abaca", "abacate", "abacay"
        };
        for (int i = 0; i < words.length; ++i) {
            s1.add(words[i]);
            // After each addition, check all words for membership
            for (int j = 0; j < words.length; ++j) {
                if (j <= i) assertTrue(s1.contains(words[j]));
                else        assertFalse(s1.contains(words[j]));
            }
        }
        for (int i = 0; i < words.length; ++i) {
            s1.remove(words[i]);
            // After each deletion, check all words for membership
            for (int j = 0; j < words.length; ++j) {
                if (j <= i) assertFalse(s1.contains(words[j]));
                else        assertTrue(s1.contains(words[j]));
            }
        }
    }

}
