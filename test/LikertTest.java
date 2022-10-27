import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import questionnaire.Likert;
import questionnaire.Question;

/**
 * Test class for Likert quesiton class.
 */
public class LikertTest {

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
   * Question 7.
   */
  Question q7;
  /**
   * Question 8.
   */
  Question q8;
  /**
   * Question 9.
   */
  Question q9;
  /**
   * Question 10.
   */
  Question q10;

  /**
   * Sets up objects for test.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    q1 = new Likert("Annie, are you okay?", true);
    q2 = new Likert("Are you okay, Annie?", false);
    q3 = new Likert("Will you tell us that you're okay?", true);
    q4 = new Likert("So, Annie, are you okay?", false);
    q5 = new Likert("Annie, Okay?", true);

    q6 = new Likert("Annie, are you okay?", false);
    q7 = new Likert("Are you okay, Annie?", true);
    q8 = new Likert("Will you tell us that you're okay?", false);
    q9 = new Likert("So, Annie, are you okay?", true);
    q10 = new Likert("Annie, Okay?", false);

  }

  /**
   * Tests answer method.
   */
  @org.junit.Test
  public void answer() {
    q1.answer("Strongly Agree");
    q2.answer("Agree");
    q3.answer("Neither Agree Nor Disagree");
    q4.answer("Disagree");
    q5.answer("Strongly Disagree");

    assertEquals("Strongly Agree", q1.getAnswer());
    assertEquals("Agree", q2.getAnswer());
    assertEquals("Neither Agree Nor Disagree", q3.getAnswer());
    assertEquals("Disagree", q4.getAnswer());
    assertEquals("Strongly Disagree", q5.getAnswer());

    q6.answer("sTRONGLY aGREE");
    q7.answer("AGRee");
    q8.answer("NEITHER agree NOR disagree");
    q9.answer("disAGREE");
    q10.answer("sTrOnGlY DiSaGrEe");

    assertEquals("sTRONGLY aGREE", q6.getAnswer());
    assertEquals("AGRee", q7.getAnswer());
    assertEquals("NEITHER agree NOR disagree", q8.getAnswer());
    assertEquals("disAGREE", q9.getAnswer());
    assertEquals("sTrOnGlY DiSaGrEe", q10.getAnswer());
  }

  /**
   * Test exceptions from answer method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void answerException() {
    q1.answer("Strongly Agree.");
    q2.answer("Agreee");
    q3.answer("Neither Agree no Disagree");
    q4.answer("Disagre");
    q5.answer("Strongly Disagree!");

    q6.answer("");
    q7.answer("Not the correct response.");
  }

  /**
   * Test copy method.
   */
  public void copy(){

    q1.answer("Strongly Agree");

    q4 = q1.copy();
    q5 = q2.copy();
    q6 = q3.copy();

    q3.answer("Neither agree nor disagree");

    assertTrue(q4.equals(q1) && q4 != q1);
    assertTrue(q5.equals(q2) && q5 != q2);
    assertNotEquals(q6, q3);
  }
}