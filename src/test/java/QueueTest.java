import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private Queue empty, one, two;

    @BeforeEach
    void setUp() {
        empty = new Queue();

        one = new Queue();
        one.join("red");

        two = new Queue();
        two.join("red");
        two.join("blue");
    }

    @Test
    void emptyQueueIsEmpty() {
        assertTrue(empty.isEmpty());
    }

    @Test
    void nonEmptyQueueIsNotEmpty() {
        assertFalse(one.isEmpty());
    }

    @Test
    void emptyQueueSize() {
        assertEquals(0, empty.size());
    }

    @Test
    void oneQueueSize() {
        assertEquals(1, one.size());
    }

    @Test
    void twoQueueSize() {
        assertEquals(2, two.size());
    }

    @Test
    void oneQueueServe() {
        assertEquals("red", one.serve());
        assertEquals(0, one.size());
        assertTrue(one.isEmpty());
    }

    @Test
    void twoQueueServerFirst() {
        assertEquals("red", two.serve());
        assertEquals(1, two.size());
        assertFalse(two.isEmpty());
    }

    @Test
    void twoQueueServerSecond() {
        two.serve();

        assertEquals("blue", two.serve());
        assertEquals(0, two.size());
        assertTrue(two.isEmpty());
    }
}