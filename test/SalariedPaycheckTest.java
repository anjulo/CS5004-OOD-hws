import org.junit.Before;
import org.junit.Test;

import employee.SalariedPaycheck;

import static org.junit.Assert.*;

public class SalariedPaycheckTest {

  SalariedPaycheck pc1;
  SalariedPaycheck pc2;
  SalariedPaycheck pc3;

  @Before
  public void setUp() throws Exception {
    pc1 = new SalariedPaycheck(100_000.00, 1);
    pc2 = new SalariedPaycheck(150_000.00, 2);
    pc3 = new SalariedPaycheck(200_000.00, 4);

  }

  @Test(expected = IllegalArgumentException.class)
  public void exceptionsTest(){
    pc1 = new SalariedPaycheck(100_000, -1);
    pc2 = new SalariedPaycheck(150_000, 3);
    pc2 = new SalariedPaycheck(200_00, 5);
  }

  @Test
  public void getTotalPay() {
    assertEquals(100_000.00 / 52 * 1, pc1.getTotalPay(), 0.01);
    assertEquals(150_000.00 / 52 * 2, pc2.getTotalPay(), 0.01);
    assertEquals(200_000.00 / 52 * 4, pc3.getTotalPay(), 0.01);

  }
}