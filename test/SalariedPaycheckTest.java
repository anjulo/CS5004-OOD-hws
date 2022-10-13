import static org.junit.Assert.assertEquals;

import employee.SalariedPaycheck;
import org.junit.Before;
import org.junit.Test;

/**
 * Class for testing Salaried paycheck class.
 */
public class SalariedPaycheckTest {

  /**
   * Paycheck 1.
   */
  SalariedPaycheck pc1;
  /**
   * Paycheck 2.
   */
  SalariedPaycheck pc2;
  /**
   * Paycheck 3.
   */
  SalariedPaycheck pc3;

  /**
   * Sets up sample paychecks for test purposes.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    pc1 = new SalariedPaycheck(100_000.00, 1);
    pc2 = new SalariedPaycheck(150_000.00, 2);
    pc3 = new SalariedPaycheck(200_000.00, 4);

  }

  /**
   * Tests exceptions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void exceptionsTest() {
    pc1 = new SalariedPaycheck(100_000, -1);
    pc2 = new SalariedPaycheck(150_000, 3);
    pc2 = new SalariedPaycheck(200_00, 5);
  }

  /**
   * Tests getTotalPay.
   */
  @Test
  public void getTotalPay() {
    assertEquals(100_000.00 / 52 * 1, pc1.getTotalPay(), 0.01);
    assertEquals(150_000.00 / 52 * 2, pc2.getTotalPay(), 0.01);
    assertEquals(200_000.00 / 52 * 4, pc3.getTotalPay(), 0.01);

  }
}