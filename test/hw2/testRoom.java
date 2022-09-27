package hw2;

import org.junit.Before;
import org.junit.Test;

import static hw2.Room.RoomType.*;
import static org.junit.Assert.*;

public class testRoom {

  private Room room1;
  private Room room2;
  private Room room3;
  private Room room4;
  private Room room5;

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

  @Test
  public void testIsAvailable() {
    assertTrue(room1.isAvailable());
    assertTrue(room2.isAvailable());
    assertTrue(room3.isAvailable());
    assertFalse(room4.isAvailable());
    assertFalse(room5.isAvailable());
  }

  @Test
  public void testBookRoom() {
    assertEquals(2, room4.getNumberOfGuests());
    assertEquals(1, room5.getNumberOfGuests());
  }

  @Test
  public void testGetNumberOfGuests() {
    assertEquals(0, room1.getNumberOfGuests());
    assertEquals(0, room2.getNumberOfGuests());
    assertEquals(2, room4.getNumberOfGuests());
    assertEquals(1, room5.getNumberOfGuests());
  }
}