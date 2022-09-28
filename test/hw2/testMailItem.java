package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the MailItem.
 */
public class testMailItem {

  private Recipient tom;
  private Recipient jerry;
  private MailItem shoes;
  private MailItem cheese;
  private MailItem shoes2;
  private MailItem cheese2;


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
   * Bad inputs to test the exception throwing.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadMailItem(){

    shoes = new MailItem(0.5, 2, 3, tom);
    cheese = new MailItem(1.0,0.756,1.2, jerry);

    shoes2 = new MailItem(4.5,2,0.999999999, tom);

    cheese2 = new MailItem(1.0,1.5,1.2, null);



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