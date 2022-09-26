package hw2;

/**
 * The Room class.
 */
public class Room {

  private int maxOccupancy;
  private double price;
  private int numOfGuests;

  /**
   * The enumerator class for Room type.
   */
  enum RoomType {
    /**
     * Single room with maximum occupancy of 1.
     */
    SINGLE,
    /**
     * Double room with maximum occupancy of 2.
     */
    DOUBLE,
    /**
     * Family room with maximum occupancy of 4.
     */
    FAMILY};

}
