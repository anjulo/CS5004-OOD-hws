import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import employee.Employee;
import employee.HourlyPaycheck;
import employee.SalariedPaycheck;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Employee test.
 */
public class EmployeeTest {

  /**
   * The Employee 1.
   */
  Employee emp1;
  /**
   * The Employee 2.
   */
  Employee emp2;
  /**
   * The Employee 3.
   */
  Employee emp3;
  /**
   * The Employee 4.
   */
  Employee emp4;

  /**
   * Sets up sample employees for test.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    emp1 = new Employee("Sam", "sm", 240_000, 2, false);
    emp2 = new Employee("John", "jh", 150_000, 1, true);
    emp3 = new Employee("Tony", "tn", 100, 20);
    emp4 = new Employee("Kim", "km", 19, 0);
  }

  /**
   * Test exception .
   */
  @Test(expected = IllegalArgumentException.class)
  public void exceptionTest() {
    new Employee(null, "sm", 240_000, 2, false);
    new Employee("", "sm", 240_000, 2, false);
    new Employee("Sam", null, 240_000, 2, false);
    new Employee("Sam", "", 240_000, 2, false);

    new Employee("Sam", "sm", -0.01, 2, false);
    new Employee("Sam", "sm", 240_000, 0, false);

    emp3 = new Employee(null, "tn", 100, 20);
    emp3 = new Employee("", "tn", 100, 20);
    emp3 = new Employee("Tony", null, 100, 20);
    emp3 = new Employee("Tony", "", 100, 20);

    emp3 = new Employee("Tony", "tn", -100, 20);
    emp3 = new Employee("Tony", "tn", 100, -20);


  }

  /**
   * test the isManager function.
   */
  @Test
  public void isManager() {
    assertFalse(emp1.isManager());
    assertTrue(emp2.isManager());

    assertFalse(emp3.isManager());
    assertFalse(emp4.isManager());
  }

  /**
   * tests getPaycheck function.
   */
  @Test
  public void getPaycheck() {

    assertEquals(new SalariedPaycheck(240_000, 2), emp1.getPaycheck());
    assertEquals(new SalariedPaycheck(150_000, 1), emp2.getPaycheck());

    assertEquals(new HourlyPaycheck(100, 20), emp3.getPaycheck());
    assertEquals(new HourlyPaycheck(19, 0), emp4.getPaycheck());
  }

  /**
   * Test toString function.
   */
  @Test
  public void testToString() {
    assertEquals("Name: Sam\nID: sm\nPayment after taxes: $ 7846.15", emp1.toString());
    assertEquals("Name: John\nID: jh\nPayment after taxes: $ 2451.92", emp2.toString());

    assertEquals("Name: Tony\nID: tn\nPayment after taxes: $ 1700.00", emp3.toString());
    assertEquals("Name: Kim\nID: km\nPayment after taxes: $ 0.00", emp4.toString());
  }

}