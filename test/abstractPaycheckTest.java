import org.junit.Before;
import org.junit.Test;

import employee.HourlyPaycheck;
import employee.SalariedPaycheck;
import employee.abstractPaycheck;

import static org.junit.Assert.*;

public class abstractPaycheckTest {

  abstractPaycheck pc1;
  abstractPaycheck pc2;
  abstractPaycheck pc3;
  abstractPaycheck pc4;
  abstractPaycheck pc5;

  @Before
  public void setUp() throws Exception {
    pc1 = new HourlyPaycheck(100, 20);
    pc2 = new SalariedPaycheck(150_000, 2);

    pc3 = new HourlyPaycheck(20, 15);
    pc4 = new SalariedPaycheck(20_280.00, 1);

    // 1 cent
    pc5 = new HourlyPaycheck(9, 0.001);

  }

  @Test(expected = IllegalArgumentException.class)
  public void exceptionTest(){
    pc1 = new HourlyPaycheck(-100, 20);
    pc2 = new SalariedPaycheck(-150_000, 1);

  }

  @Test
  public void getPayRate() {
    assertEquals(100, pc1.getPayRate(), 0.01);
    assertEquals(150_000, pc2.getPayRate(), 0.01);
  }

  @Test
  public void getPayAfterTaxesTest(){
    assertEquals(1700, pc1.getPayAfterTaxes(), 0.01);
    assertEquals(4903.846, pc2.getPayAfterTaxes(), 0.01);

    assertEquals(270, pc3.getPayAfterTaxes(), 0.01);
    assertEquals(351.0, pc4.getPayAfterTaxes(), 0.01);

    assertEquals(0.01, pc5.getPayAfterTaxes(), 0.001);
  }

  @Test
  public void toStringTest(){
    assertEquals("Payment after taxes: $ 1700.00", pc1.toString());
    assertEquals("Payment after taxes: $ 4903.85", pc2.toString());

    assertEquals("Payment after taxes: $ 270.00", pc3.toString());
    assertEquals("Payment after taxes: $ 351.00", pc4.toString());

    assertEquals("Payment after taxes: $ 0.01", pc5.toString());

  }
}