package hw2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class testLocker {

  private Recipient tom;
  private Recipient jerry;

  private MailItem shoes;
  private MailItem cheese;
  Locker locker1;
  Locker locker2;
  Locker locker3;

  @Before
  public void setUp() throws Exception {

    tom = new Recipient("Thomas", "Cat", "tom@tomandjerry.com");
    jerry = new Recipient("Gerald", "Mouse", "jerry@tomandjerry.com");
    shoes = new MailItem(3.5,2,3,tom);
    cheese = new MailItem(1.0,1.5,1.2, jerry);
    locker1 = new Locker(4,4,6);
    locker2 = new Locker(2,2,3);
    locker3 = new Locker(1,1,1.5);


    locker1.addMail(shoes);
    locker2.addMail(cheese);
  }

  @Test
  public void testAddMail() {
    assertEquals(shoes, locker1.getMail(shoes.getRecipient()));
    assertEquals(cheese, locker2.getMail(cheese.getRecipient()));
  }

  @Test
  public void testPickupMail() {
    assertEquals(shoes, locker1.pickupMail(tom));
    assertEquals(cheese, locker2.pickupMail(jerry));
    assertNotEquals(shoes, locker1.pickupMail(jerry));
    assertNotEquals(cheese, locker2.pickupMail(tom));

    assertEquals(null, locker3.pickupMail(jerry));
  }
}