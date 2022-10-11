import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * The TestPaycheck class.
 */
public class TestPaycheck {

  private static Paycheck payCheck1;
  private static Paycheck payCheck2;

  /**
   * Sets up two instance of the payCheck class to test with.
   *
   * @throws Exception the exception
   */
  @BeforeClass
  public static void setUp() throws Exception {
    payCheck1 = new Paycheck(30.0, 40.0);
    payCheck2 = new Paycheck(18.9, 52.3);
  }


  /**
   * Test getTotalPay.
   */
  @Test
  public void testGetTotalPay() {
    assertEquals(1200.0, payCheck1.getTotalPay(), 0.01);
    assertEquals(1104.705, payCheck2.getTotalPay(), 0.01);
  }

  /**
   * Test getPayAfterTaxes.
   */
  @Test
  public void testGetPayAfterTaxes() {
    assertEquals(1020.00, payCheck1.getPayAfterTaxes(), 0.0);
    assertEquals(938.99, payCheck2.getPayAfterTaxes(), 0.01);
  }

  /**
   * Test toString.
   */
  @Test
  public void testToString() {
    assertEquals("Payment after taxes: $ 1,020.00", payCheck1.toString());
    assertEquals("Payment after taxes: $ 938.99", payCheck2.toString());

  }

  /**
   * Tear down.
   *
   * @throws Exception the exception
   */
  @AfterClass
  public static void tearDown() throws Exception {
  }
}