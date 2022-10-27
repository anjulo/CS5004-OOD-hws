import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import questionnaire.Question;
import questionnaire.YesNo;

/**
 * Test class for YesNo class.
 */
public class YesNoTest {

  /**
   * Question 1.
   */
  Question q1;
  /**
   * Question 2.
   */
  Question q2;
  /**
   * Question 3.
   */
  Question q3;
  /**
   * Question 4.
   */
  Question q4;
  /**
   * Question 5.
   */
  Question q5;
  /**
   * Question 6.
   */
  Question q6;

  /**
   * Sets up questions to test.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    q1 = new YesNo("Annie, are you okay?", true);
    q2 = new YesNo("Are you okay, Annie?", false);
    q3 = new YesNo("Will you tell us that you're okay?", false);
    q4 = new YesNo("So, Annie, are you okay?", true);
    q5 = new YesNo("Annie, Okay?", false);
    q6 = new YesNo("Yes?", true);
  }

  /**
   * Test answer().
   */
  @Test
  public void answer() {
    // do i need to implement this?
    q1.answer("Yes");
    q2.answer("No");
    q3.answer("yes");
    q4.answer("no");
    q5.answer("YES");
    q6.answer("NO");

    assertEquals(q1.getAnswer(), "Yes");
    assertEquals(q2.getAnswer(), "No");
    assertEquals(q3.getAnswer(), "yes");
    assertEquals(q4.getAnswer(), "no");
    assertEquals(q5.getAnswer(), "YES");
    assertEquals(q6.getAnswer(), "NO");
  }

  /**
   * Test answer() exceptions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void answerExceptions() {

    q1.answer("");
    q2.answer(" ");
    q3.answer("yess");
    q4.answer("noo");
    q5.answer("yeah");
    q6.answer("nah");

  }

  /**
   * Test getAnswer().
   */
  @org.junit.Test
  public void getAnswer() {

    q1.answer("Yes");
    q2.answer("No");
    q3.answer("yes");
    q4.answer("no");
    q5.answer("YES");
    q6.answer("NO");

    assertEquals(q1.getAnswer(), "Yes");
    assertEquals(q2.getAnswer(), "No");
    assertEquals(q3.getAnswer(), "yes");
    assertEquals(q4.getAnswer(), "no");
    assertEquals(q5.getAnswer(), "YES");
    assertEquals(q6.getAnswer(), "NO");
  }

  /**
   * Test copy.
   */
  @Test
  public void copy(){

    q1.answer("Yes");

    q4 = q1.copy();
    q5 = q2.copy();
    q6 = q3.copy();

    q3.answer("yes");

    assertTrue(q4.equals(q1) && q4 != q1);
    assertTrue(q5.equals(q2) && q5 != q2);
    assertNotEquals(q6, q3);
  }
}