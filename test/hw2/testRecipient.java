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
  private Recipient tom2;
  private Recipient jerry2;
  private Recipient jasper2;



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
   * Test bad inputs that throw exceptions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadRecipient() {
    tom = new Recipient("", "Cat", "tom@tomandjerry.com");
    jerry = new Recipient("Gerald", "", "jerry@tomandjerry.com");
    jasper = new Recipient("Thomas", "Cat", "");



    tom2 = new Recipient(null, "Cat", "tom@tomandjerry.com");
    jerry2 = new Recipient("Gerald", null, "jerry@tomandjerry.com");
    jasper2 = new Recipient("Thomas", "Cat", null);

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
    assertEquals(str1, jasper.toString());
    assertEquals(str2, jinx.toString());
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