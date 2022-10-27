import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import questionnaire.Likert;
import questionnaire.Question;
import questionnaire.ShortAnswer;
import questionnaire.YesNo;

/**
 * Test class for the Abstract question class.
 */
public class abstractQuestionTest {

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
   * Sets up question for test.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    q1 = new YesNo("Annie, are you okay?", true);
    q2 = new ShortAnswer("Are you okay, Annie?", false);
    q3 = new Likert("Annie is okay!", true);
  }

  /**
   * Test constructor exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void setUpException() {
    q1 = new YesNo("", true);
    q2 = new YesNo(null, false);
  }

  /**
   * Test getPrompt.
   */
  @Test
  public void getPrompt() {
    assertEquals(q1.getPrompt(), "Annie, are you okay?");
    assertEquals(q2.getPrompt(), "Are you okay, Annie?");
    assertEquals(q3.getPrompt(), "Annie is okay!");

  }

  /**
   * Test isRequired.
   */
  @Test
  public void isRequired() {
    assertTrue(q1.isRequired());
    assertFalse(q2.isRequired());
    assertTrue(q3.isRequired());
  }

  /**
   * Test getAnswer.
   */
  @Test
  public void getAnswer() {
    assertEquals(q1.getAnswer(), "");
    q2.answer("Yeah, I'm fine.");
    assertEquals(q2.getAnswer(), "Yeah, I'm fine.");
    q3.answer("Strongly Agree");
    assertEquals(q3.getAnswer(), "Strongly Agree");

  }
}