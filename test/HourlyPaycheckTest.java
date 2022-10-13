import static org.junit.Assert.assertEquals;

import employee.HourlyPaycheck;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Hourly paycheck test.
 */
public class HourlyPaycheckTest {

  /**
   * Paycheck 1.
   */
  HourlyPaycheck pc1;
  /**
   * Paycheck 2.
   */
  HourlyPaycheck pc2;
  /**
   * Paycheck 3.
   */
  HourlyPaycheck pc3;

  /**
   * Sets up sample paychecks to test.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    pc1 = new HourlyPaycheck(100, 20);
    pc2 = new HourlyPaycheck(19, 0);
    pc3 = new HourlyPaycheck(50, 45);
  }

  /**
   * Tests Exceptions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void exceptionTest() {
    pc1 = new HourlyPaycheck(100, -20);
    pc2 = new HourlyPaycheck(19, -0.01);
  }

  /**
   * Tests getHoursWorked.
   */
  @Test
  public void getHoursWorked() {
    assertEquals(20, pc1.getHoursWorked(), 0.01);
    assertEquals(0, pc2.getHoursWorked(), 0.01);
  }

  /**
   * Tests addHoursWorked.
   */
  @Test
  public void addHoursWorked() {
    pc1.addHoursWorked(10);
    assertEquals(30, pc1.getHoursWorked(), 0.01);
    pc1.addHoursWorked(-5);
    assertEquals(25, pc1.getHoursWorked(), 0.01);
    pc1.addHoursWorked(-25);
    assertEquals(0, pc1.getHoursWorked(), 0.01);

    pc2.addHoursWorked(10);
    assertEquals(10, pc2.getHoursWorked(), 0.01);
    pc2.addHoursWorked(-15);
    assertEquals(0, pc2.getHoursWorked(), 0.01);
  }

  /**
   * Tests resetHoursWorked.
   */
  @Test
  public void resetHoursWorked() {
    pc1.resetHoursWorked();
    assertEquals(0, pc1.getHoursWorked(), 0.01);
    pc2.resetHoursWorked();
    assertEquals(0, pc2.getHoursWorked(), 0.01);
  }

  /**
   * Tests getTotalPay.
   */
  @Test
  public void getTotalPay() {
    assertEquals(100 * 20, pc1.getTotalPay(), 0.01);
    assertEquals(19 * 0, pc2.getTotalPay(), 0.01);
    assertEquals(50 * (40 + 1.5 * 5), pc3.getTotalPay(), 0.01);
  }
}