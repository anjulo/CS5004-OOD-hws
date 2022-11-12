import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import cs5004.collections.EmptyPriorityQueueException;
import cs5004.collections.ListPriorityQueue;
import cs5004.collections.PriorityQueue;
import org.junit.Before;
import org.junit.Test;


/**
 * Test for Empty node class.
 */
public class EmptyNodeTest {

  PriorityQueue q0;
  PriorityQueue q1;
  PriorityQueue q2;
  PriorityQueue q3;
  PriorityQueue q01;

  /**
   * Sets up example objects to be used for test.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    q0 = ListPriorityQueue.createEmpty();
    q01 = ListPriorityQueue.createEmpty();


  }

  /**
   * Tests isEmpty().
   */
  @Test
  public void isEmptyTest() {
    assertTrue(q0.isEmpty());
  }

  /**
   * Tests add().
   */
  @Test
  public void addTest() {
    q1 = q0.add(1, "one");
    assertEquals(q1, new ListPriorityQueue(1, "one", q0));
    q2 = q0.add(10, "ten");
    assertEquals(q2, new ListPriorityQueue(10, "ten", q0));
    q3 = q0.add(5, "five");
    assertEquals(q3, new ListPriorityQueue(5, "five", q0));

  }

  /**
   * Test exceptions in add().
   */
  @Test
  public void addExceptionsTest() {
    int exceptionsCount = 0;
    try {
      q1 = q0.add(0, "zero");
    } catch (IllegalArgumentException e) {
      exceptionsCount++;
    }
    try {
      q1 = q0.add(11, "eleven");
    } catch (IllegalArgumentException e) {
      exceptionsCount++;
    }
    assertEquals(2, exceptionsCount);
  }

  /**
   * Tests peek().
   */
  @Test
  public void peekTest() throws EmptyPriorityQueueException {
    int exceptionsCount = 0;
    try {
      q0.peek();
    } catch (EmptyPriorityQueueException e) {
      exceptionsCount++;
    }
    try {
      q01.peek();
    } catch (EmptyPriorityQueueException e) {
      exceptionsCount++;
    }
    assertEquals(2, exceptionsCount);
  }

  /**
   * Tests pop().
   */
  @Test
  public void popTest() throws EmptyPriorityQueueException {
    int exceptionsCount = 0;
    try {
      q0.pop();
    } catch (EmptyPriorityQueueException e) {
      exceptionsCount++;
    }
    try {
      q01.pop();
    } catch (EmptyPriorityQueueException e) {
      exceptionsCount++;
    }
    assertEquals(2, exceptionsCount);
  }

  /**
   * Tests toString().
   */
  @Test
  public void toStringTest() {
    assertEquals("", q0.toString());
    assertEquals("", q01.toString());
  }

  /**
   * Tests equals().
   */
  @Test
  public void equalsTest() {
    assertEquals(q0, q01);
    assertSame(q0, q01); // singlton class
  }

}