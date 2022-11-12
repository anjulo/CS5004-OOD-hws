package cs5004.collections;

import java.util.Objects;

/**
 * The List priority queue concrete class.
 */
public class ListPriorityQueue implements PriorityQueue {

  private Integer priority;
  private String value;
  private PriorityQueue rest;


  /**
   * Instantiates a new priority queue.
   *
   * @param priority the priority
   * @param value    the value
   * @param rest     the rest of the priority queue
   */
  public ListPriorityQueue(Integer priority, String value, PriorityQueue rest) {
    this.priority = priority;
    this.value = value;
    this.rest = rest;
  }

  /**
   * Creates an empty priority queue.
   *
   * @return the empty priority queue
   */
  public static PriorityQueue createEmpty() {
    return EmptyNode.getInstance();
  }

  /**
   * Checks if the priority queue is empty.
   *
   * @return true if the PQ is empty, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return false;
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
      throw new IllegalArgumentException("Input priority out of allowed ranges");
    }
    if (priority > this.priority) {
      return new ListPriorityQueue(priority, value, this);
    }
    return new ListPriorityQueue(this.priority, this.value, this.rest.add(priority, value));
  }

  /**
   * Gets the value of the highest priority element. If there are multiple elements
   * that have the same priority, gets
   * the value  of the most recently added element.
   *
   * @return The value  of the highest priority element.
   */
  @Override
  public String peek() {
    return this.value;
  }

  /**
   * Removes the highest priority element.
   *
   * @return A copy of the priority queue without the highest priority element.
   */
  @Override
  public PriorityQueue pop() {
    return this.rest;
  }

  @Override
  public String toString() {
    return  priority.toString() + "," + value + " --> " + rest.toString();
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ListPriorityQueue)) {
      return false;
    }
    ListPriorityQueue that = (ListPriorityQueue) o;
    return this.priority.equals(that.priority)
            && this.value.equals(that.value)
            && this.rest.equals(that.rest);
  }

  @Override
  public String toString() {
    return "{"
            + "priority=" + priority.toString()
            + ", value='" + value + "',"
            + rest.toString()
            + "}";
  }

  @Override
  public int hashCode() {
    return Objects.hash(priority, value, rest);
  }
}
