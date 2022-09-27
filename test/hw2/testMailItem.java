package hw2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for the MailItem.
 */
public class testMailItem {

  private Recipient tom;
  private Recipient jerry;
  private MailItem shoes;
  private MailItem cheese;


  /**
   * Sets up some instance of the MailItem class.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    tom = new Recipient("Thomas", "Cat", "tom@tomandjerry.com");
    jerry = new Recipient("Gerald", "Mouse", "jerry@tomandjerry.com");
    shoes = new MailItem(4.5,  2, 3, tom);
    cheese = new MailItem(1.0, 1.5, 1.2, jerry);

  }

  /**
   * Tests getRecipient() method.
   */
  @Test
  public void testGetRecipient() {
    assertEquals(tom, shoes.getRecipient());
    assertEquals(jerry, cheese.getRecipient());
  }

  /**
   * Bas inputs to test the exception throwing.
   */
  @Test
  public void testBadInput(){

  }

  /**
   * Gets width.
   */
  @Test
  public void getWidth() {
  }

  /**
   * Gets height.
   */
  @Test
  public void getHeight() {
  }

  /**
   * Gets depth.
   */
  @Test
  public void getDepth() {
  }
}