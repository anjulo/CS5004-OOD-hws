import org.junit.Before;
import org.junit.Test;

import employee.HourlyPaycheck;
import employee.SalariedPaycheck;
import employee.abstractPaycheck;

import static org.junit.Assert.*;

public class abstractPaycheckTest {

  abstractPaycheck pc1;
  abstractPaycheck pc2;

  @Before
  public void setUp() throws Exception {
    pc1 = new HourlyPaycheck(100, 20);
    pc2 = new SalariedPaycheck(100_00, 1);

  }

  @Test(expected = IllegalArgumentException.class)
  public void exceptionTest(){
    pc1 = new HourlyPaycheck(-100, 20);
    pc2 = new SalariedPaycheck(-100_00, 1);

  }

  @Test
  public void getPayRate() {
    assertEquals(100, pc1.getPayRate(), 0.01);
    assertEquals(100_00.0, pc2.getPayRate(), 0.01);
  }
}