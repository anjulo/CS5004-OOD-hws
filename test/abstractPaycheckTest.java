import static org.junit.Assert.assertEquals;

import employee.HourlyPaycheck;
import employee.SalariedPaycheck;
import employee.abstractPaycheck;
import org.junit.Before;
import org.junit.Test;


/**
 * Test for the Abstract paycheck class.
 */
public class abstractPaycheckTest {

  /**
   * paycheck 1.
   */
  abstractPaycheck pc1;
  /**
   * paycheck 2.
   */
  abstractPaycheck pc2;
  /**
   * paycheck 3.
   */
  abstractPaycheck pc3;
  /**
   * paycheck 4.
   */
  abstractPaycheck pc4;
  /**
   * paycheck 5.
   */
  abstractPaycheck pc5;

  /**
   * Sets up sample paychecks to test.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    pc1 = new HourlyPaycheck(100, 20);
    pc2 = new SalariedPaycheck(150_000, 2);

    pc3 = new HourlyPaycheck(20, 15);
    pc4 = new SalariedPaycheck(20_280.00, 1);

    // 1 cent
    pc5 = new HourlyPaycheck(9, 0.001);

  }

  /**
   * Tests Exceptions in the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void exceptionTest() {
    pc1 = new HourlyPaycheck(-100, 20);
    pc2 = new SalariedPaycheck(-150_000, 1);

  }

  /**
   * Tests getPayRate.
   */
  @Test
  public void getPayRate() {
    assertEquals(100, pc1.getPayRate(), 0.01);
    assertEquals(150_000, pc2.getPayRate(), 0.01);
  }

  /**
   * Tests getPayAfterTaxes.
   */
  @Test
  public void getPayAfterTaxesTest() {
    assertEquals(1700, pc1.getPayAfterTaxes(), 0.01);
    assertEquals(4903.846, pc2.getPayAfterTaxes(), 0.01);

    assertEquals(270, pc3.getPayAfterTaxes(), 0.01);
    assertEquals(351.0, pc4.getPayAfterTaxes(), 0.01);

    assertEquals(0.01, pc5.getPayAfterTaxes(), 0.001);
  }

  /**
   * tests toString.
   */
  @Test
  public void toStringTest() {
    assertEquals("Payment after taxes: $ 1700.00", pc1.toString());
    assertEquals("Payment after taxes: $ 4903.85", pc2.toString());

    assertEquals("Payment after taxes: $ 270.00", pc3.toString());
    assertEquals("Payment after taxes: $ 351.00", pc4.toString());

    assertEquals("Payment after taxes: $ 0.01", pc5.toString());

  }
}