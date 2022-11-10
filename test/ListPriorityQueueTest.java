import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import cs5004.collections.EmptyNode;
import cs5004.collections.EmptyPriorityQueueException;
import cs5004.collections.ListPriorityQueue;
import cs5004.collections.PriorityQueue;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for priority queue class.
 */
public class ListPriorityQueueTest {

  PriorityQueue q0;
  PriorityQueue q1;
  PriorityQueue q2;
  PriorityQueue q3;
  PriorityQueue q4;
  /**
   * Sets up example objects to be used for test.
   *
   * @throws Exception the exception
   */

  @Before
  public void setUp() {
    q0 = new EmptyNode();
    q1 = new ListPriorityQueue(1, "one", q0);
    q2 = new ListPriorityQueue(2, "two", q1);
  }

  /**
   * Tests createEmpty().
   */
  @Test
  public void createEmpty() {
    q3 = ListPriorityQueue.createEmpty();
    assertEquals(q0, q2);
  }

  /**
   * Tests isEmpty().
   */
  @Test
  public void isEmpty() {
    assertFalse(q1.isEmpty());
    assertFalse(q2.isEmpty());
  }

  /**
   * Tests add().
   */
  @Test
  public void add() {
    q3 = q1.add(3, "three");
    assertEquals(new ListPriorityQueue(3, "three", q1), q3);
    q4 = q2.add(10, "ten");
    assertEquals(new ListPriorityQueue(10, "ten", q2), q4);
  }

  /**
   * Test exceptions in add().
   */
  @Test
  public void addExceptions() {
    int exceptionsCount = 0;
    try {
      q3 = q1.add(0, "zero");
    } catch (IllegalArgumentException e) {
      exceptionsCount++;
    }
    try {
      q4 = q2.add(11, "eleven");
    } catch (IllegalArgumentException e) {
      exceptionsCount++;
    }
    assertEquals(2, exceptionsCount);
  }

  /**
   * Tests peek().
   */
  @Test
  public void peek() throws EmptyPriorityQueueException {
    assertEquals("one", q1.peek());
    assertEquals("two", q2.peek());
  }

  /**
   * Tests pop().
   */
  @Test
  public void pop() throws EmptyPriorityQueueException {

    q3 = q2.add(3, "three");

    assertEquals(q2, q3.pop());
    assertEquals(q1, q2.pop());
    assertEquals(q0, q1.pop());
  }

  /**
   * Tests equals().
   */
  @Test
  public void testEquals() {
  }

  /**
   * Tests hashCode().
   */
  @Test
  public void testHashCode() {
  }
}