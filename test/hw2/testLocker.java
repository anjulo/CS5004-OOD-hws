package hw2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 *Test class for the locker class.
 */
public class testLocker {

  private Recipient tom;
  private Recipient jerry;

  private MailItem shoes;
  private MailItem cheese;
  /**
   * The Locker 1.
   */
  Locker locker1;
  /**
   * The Locker 2.
   */
  Locker locker2;
  /**
   * The Locker 3.
   */
  Locker locker3;

  /**
   * Sets up locker instances to be tested.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {

    tom = new Recipient("Thomas", "Cat", "tom@tomandjerry.com");
    jerry = new Recipient("Gerald", "Mouse", "jerry@tomandjerry.com");
    shoes = new MailItem(3.5, 2, 3, tom);
    cheese = new MailItem(1.0, 1.5, 1.2, jerry);
    locker1 = new Locker(4, 4, 6);
    locker2 = new Locker(2, 2, 3);
    locker3 = new Locker(1, 1, 1.5);


    locker1.addMail(shoes);
    locker2.addMail(cheese);
  }

  /**
   * Bad inputs to test the exception throwing.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadLocker(){

    locker1 = new Locker(0.9999, 1.5, 3.4);
    locker2 = new Locker(2.3, 0.987, 2.4);
    locker3 = new  Locker(5.4,1.2, -1.2);


  }

  /**
   * Tester for the addMail() method.
   */
  @Test
  public void testAddMail() {
    assertEquals(shoes, locker1.getMail(shoes.getRecipient()));
    assertEquals(cheese, locker2.getMail(cheese.getRecipient()));
  }

  /**
   *Tester for the pickupMail() method.
   */
  @Test
  public void testPickupMail() {
    assertEquals(shoes, locker1.pickupMail(tom));
    assertEquals(cheese, locker2.pickupMail(jerry));
    assertNotEquals(shoes, locker1.pickupMail(jerry));
    assertNotEquals(cheese, locker2.pickupMail(tom));

    assertEquals(null, locker3.pickupMail(jerry));
  }
}