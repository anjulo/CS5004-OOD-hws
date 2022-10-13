import org.junit.Before;
import org.junit.Test;

import employee.HourlyPaycheck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class HourlyPaycheckTest {

  HourlyPaycheck pc1;
  HourlyPaycheck pc2;
  HourlyPaycheck pc3;

  @Before
  public void setUp() throws Exception {
    pc1 = new HourlyPaycheck(100, 20);
    pc2 = new HourlyPaycheck(19, 0);
    pc3 = new HourlyPaycheck(50, 45);
  }

  @Test(expected = IllegalArgumentException.class)
  public void exceptionTest(){
    pc1 = new HourlyPaycheck(100, -20);
    pc2 = new HourlyPaycheck(19, -0.01);
  }

  @Test
  public void getHoursWorked() {
    assertEquals(20, pc1.getHoursWorked(), 0.01);
    assertEquals(0, pc2.getHoursWorked(), 0.01);
  }

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

  @Test
  public void resetHoursWorked() {
    pc1.resetHoursWorked();
    assertEquals(0, pc1.getHoursWorked(), 0.01);
    pc2.resetHoursWorked();
    assertEquals(0, pc2.getHoursWorked(),0.01);
  }
  @Test
  public void getTotalPay() {
    assertEquals(100*20, pc1.getTotalPay(), 0.01);
    assertEquals(19 * 0, pc2.getTotalPay(), 0.01);
    assertEquals(50 * (40 + 1.5 * 5), pc3.getTotalPay(), 0.01);
  }
}