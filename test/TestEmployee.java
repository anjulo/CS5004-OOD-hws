import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * The TestEmployee class.
 */
public class TestEmployee {

  private Employee michael;
  private Employee dwight;
  private Employee darryl;
  private Employee kevin;

  /**
   * Sets up the instances to test the methods with.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    michael = new Employee("Michael Gary Scott", "mscott", 20.0);
    michael.addHoursWorked(30.3);
    dwight = new Employee("Dwight Kurt Schrute", "dschrute", 30.0);
    dwight.addHoursWorked(-5.0);
    darryl = new Employee("Darryl Philbin", "dphilbin", 25.0);
    darryl.addHoursWorked(20.5);
    kevin = new Employee("Kevin Malone", "kmalone", 15.0);
    kevin.addHoursWorked(11.12);

  }

  /**
   * Test addHoursWorked.
   */
  @Test
  public void testAddHoursWorked() {

    michael.addHoursWorked(15.90);
    darryl.addHoursWorked(-5.0);
    kevin.addHoursWorked(-20.0);


    assertEquals(46.20, michael.getHoursWorked(), 0.01);
    assertEquals(0.0, dwight.getHoursWorked(), 0.01);
    assertEquals(15.5, darryl.getHoursWorked(), 0.01);
    assertEquals(0.0, kevin.getHoursWorked(), 0.01);

  }

  /**
   * Test resetHoursWorked.
   */
  @Test
  public void testResetHoursWorked() {
    michael.resetHoursWorked();
    dwight.resetHoursWorked();
    darryl.resetHoursWorked();

    assertEquals(0.0, michael.getHoursWorked(), 0.0);
    assertEquals(0.0, dwight.getHoursWorked(), 0.0);
    assertEquals(0.0, darryl.getHoursWorked(), 0.0);

  }

  /**
   * Test getHoursWorked.
   */
  @Test
  public void testGetHoursWorked() {

    assertEquals(30.3, michael.getHoursWorked(), 0.01);
    assertEquals(0.0, dwight.getHoursWorked(), 0.01);
    assertEquals(20.5, darryl.getHoursWorked(), 0.01);
  }

  /**
   * Test getWeeklyCheck.
   */
  @Test
  public void testGetWeeklyCheck() {
    Paycheck payCheck1 = new Paycheck(30.0, 40.0);
    assertNotNull(payCheck1);
    assertTrue(payCheck1 instanceof Paycheck);

  }

  /**
   * Test toString.
   */
  @Test
  public void testToString() {

    String michaelString = "Name: Michael Gary Scott\nID: mscott\nPayment after taxes: $ 515.10\n";
    assertEquals(michaelString, michael.toString());

  }

  /**
   * Test tear down.
   *
   * @throws Exception the exception
   */
  @After
  public void testTearDown() throws Exception {
  }
}