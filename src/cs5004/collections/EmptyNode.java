package cs5004.collections;

import java.util.Objects;

/**
 * The Empty node concrete class.
 */
public class EmptyNode implements PriorityQueue {


  /**
   * Checks if the priority queue is empty.
   *
   * @return true if the PQ is empty, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * Adds an element to the PQ.
   *
   * @param priority The element's (non-negative) priority.
   * @param value    The element's value.
   * @return A copy of the priority queue containing the new element.
   */
  @Override
  public PriorityQueue add(Integer priority, String value) throws IllegalArgumentException {
    if (priority < 1 || priority > 10) {
      throw new IllegalArgumentException();
    }
    return new ListPriorityQueue(priority, value, this);
  }

  /**
   * Gets the value of the highest priority element. If there are multiple elements
   * that have the same priority, gets
   * the value  of the most recently added element.
   *
   * @return The value  of the highest priority element.
   * @throws EmptyPriorityQueueException if the PQ is empty.
   */
  @Override
  public String peek() throws EmptyPriorityQueueException {
    throw new EmptyPriorityQueueException();
  }

  /**
   * Removes the highest priority element.
   *
   * @return A copy of the priority queue without the highest priority element.
   * @throws EmptyPriorityQueueException if the PQ is empty.
   */
  @Override
  public PriorityQueue pop() throws EmptyPriorityQueueException {
    throw new EmptyPriorityQueueException();
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof EmptyNode;
  }
}
