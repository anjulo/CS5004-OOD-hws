package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * The test class for Recipient class.
 */
public class testRecipient {

  private Recipient tom;
  private Recipient jerry;
  private Recipient jasper;
  private Recipient jinx;


  /**
   * Sets up instances to test.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    tom = new Recipient("Thomas", "Cat", "tom@tomandjerry.com");
    jerry = new Recipient("Gerald", "Mouse", "jerry@tomandjerry.com");
    jasper = new Recipient("Thomas", "Cat", "tom@tomandjerry.com");
    jinx = new Recipient("Gerald", "Mouse", "jerry@tomandjerry.com");
  }

  /**
   * Test bas inputs that throw exceptions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadInput(){

  }

  /**
   * Tests the toString() method.
   */
  @Test
  public void testToString() {
    String str1 = "Thomas Cat Email:tom@tomandjerry.com";
    String str2 = "Gerald Mouse Email:jerry@tomandjerry.com";
    assertEquals(str1, tom.toString());
    assertEquals(str2, jerry.toString());
  }

  /**
   * Tests the equals() method.
   */
  @Test
  public void testEquals() {
    tom.equals(jasper);
    jerry.equals(jinx);
  }
}