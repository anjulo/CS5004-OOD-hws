package cs5004.collections;

public class Main {

  public static void main(String[] args) throws EmptyPriorityQueueException {

    PriorityQueue q0 = ListPriorityQueue.createEmpty();
    PriorityQueue q1 = q0.add(1, "one");
    PriorityQueue q2 = q1.add(2,"two");
    PriorityQueue q3 = q2.add(4,"four");
    PriorityQueue q4 = q3.add(3,"three-1");
    PriorityQueue q5 = q4.add(3,"three-2");

    PriorityQueue p0 = ListPriorityQueue.createEmpty();
    PriorityQueue p1 = p0.add(1, "one");
    PriorityQueue p2 = p1.add(2,"two");
    PriorityQueue p3 = p2.add(4,"four");
    PriorityQueue p4 = p3.add(3,"three-1");
    PriorityQueue p5 = p4.add(3,"three-2");
  }
}
