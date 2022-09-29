package hw2;

import static hw2.RoomType.DOUBLE;
import static hw2.RoomType.FAMILY;
import static hw2.RoomType.SINGLE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * The type Test room.
 */
public class testRoom {

  private Room room1;
  private Room room2;
  private Room room3;
  private Room room4;
  private Room room5;

  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    room1 = new Room(SINGLE, 100);
    room2 = new Room(DOUBLE, 0);
    room3 = new Room(FAMILY, 250);
    room4 = new Room(DOUBLE, 150);
    room4.bookRoom(2);
    room5 = new Room(FAMILY, 400);
    room5.bookRoom(1);
  }

  /**
   * Test bad inputs that throw exceptions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadRoom() {
    room1 = new Room(SINGLE, -100);
    room2 = new Room(DOUBLE, -50);
    room3 = new Room(FAMILY, -10989839);
  }

  /**
   * Test is available.
   */
  @Test
  public void testIsAvailable() {
    assertTrue(room1.isAvailable());
    assertTrue(room2.isAvailable());
    assertTrue(room3.isAvailable());
    assertFalse(room4.isAvailable());
    assertFalse(room5.isAvailable());
  }

  /**
   * Test book room.
   */
  @Test
  public void testBookRoom() {
    assertEquals(2, room4.getNumberOfGuests());
    assertEquals(1, room5.getNumberOfGuests());
    room3.bookRoom(10);
    assertTrue(room3.isAvailable());
    room2.bookRoom(1000);
    assertTrue(room2.isAvailable());

  }

  /**
   * Test get number of guests.
   */
  @Test
  public void testGetNumberOfGuests() {
    assertEquals(0, room1.getNumberOfGuests());
    assertEquals(0, room2.getNumberOfGuests());
    assertEquals(2, room4.getNumberOfGuests());
    assertEquals(1, room5.getNumberOfGuests());
  }
}