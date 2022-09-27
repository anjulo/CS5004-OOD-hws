package hw2;

/**
 * The Room class.
 */
public class Room {

  private int maxOccupancy;
  private double price;
  private int numOfGuests;
  private RoomType roomType;

  /**
   * Instantiates a new Room class.
   *
   * @param roomType the type of the room
   * @param price    the price of the room
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Room(RoomType roomType, double price) throws IllegalArgumentException {

    if (price < 0) {
      throw new IllegalArgumentException("Price value can't be negative.");
    }
    this.price = price;

    switch (roomType) {
      case SINGLE:
        this.maxOccupancy = 1;
        break;
      case DOUBLE:
        this.maxOccupancy = 2;
        break;
      case FAMILY:
        this.maxOccupancy = 4;
        break;
      default:
        break;
    }

    this.numOfGuests = 0;
  }

  /**
   * Checks if the room is available.
   *
   * @return boolean value for availability
   */
  public Boolean isAvailable() {
    if (this.numOfGuests == 0) {
      return true;
    }
    return false;
  }

  /**
   * Books the room.
   *
   * @param numOfGuests the number of guests
   */
  public void bookRoom(int numOfGuests) {
    if (this.isAvailable() && 0 < numOfGuests && numOfGuests <= this.maxOccupancy) {
      this.numOfGuests = numOfGuests;
    }
    // what about cases where the room isn't available?
    // numOfGuests parameter isn't valid

  }

  /**
   * Getter for the number of guests in the room.
   *
   * @return the number of guests
   */
  public int getNumberOfGuests() {
    return this.numOfGuests;
  }

}
