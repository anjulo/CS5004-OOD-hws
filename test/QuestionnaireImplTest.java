import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;
import questionnaire.Likert;
import questionnaire.Question;
import questionnaire.Questionnaire;
import questionnaire.QuestionnaireImpl;
import questionnaire.ShortAnswer;
import questionnaire.YesNo;

/**
 * Test class for Questionnaire class.
 */
public class QuestionnaireImplTest {


  /**
   * Questionnaire 1.
   */
  Questionnaire Q1;
  /**
   * Questionnaire 2.
   */
  Questionnaire Q2;

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
   * Sets up questionnaire and question for test.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {

    q1 = new YesNo("Annie, are you okay?", true);
    q1.answer("Yes");

    q2 =  new ShortAnswer("explain yourself?", false);
    //q2.answer("I'm okay, dude");

    q3 = new Likert("So, you're okay?", true);
    q3.answer("Agree");

    q4 = new YesNo("yeap?", false);
    //q4.answer("yes");

    Q1 = new QuestionnaireImpl();
    Q1.addQuestion("q1", q1);
    Q1.addQuestion("q2", q2);
    Q1.addQuestion("q3", q3);
    Q1.addQuestion("q4", q4);
  }

  /**
   * Tests addQuestion.
   */
  @Test
  public void addQuestion() {
    q5 = new YesNo("Tired of testing?", true);

    q6 = new ShortAnswer("How bad is it?", false);
    q6.answer("I'm just telling you it sucks.");

    Q1.addQuestion("q5", q5);
    Q1.addQuestion("q6", q6);

    assertEquals(q5, Q1.getQuestion("q5"));
    assertEquals(q6, Q1.getQuestion("q6"));

    System.out.println(Q1.getQuestion("q6").getAnswer());

  }

  /**
   * Test addQuestion exceptions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void addQuestionException() {

    q5 = new YesNo("Tired of testing?", true);
    Q1.addQuestion("", q5);
    q6 = new ShortAnswer("How bad is it?", false);
    q6.answer("I'm just telling you it sucks.");
    Q1.addQuestion("null", q6);
  }

  /**
   * Tests removeQuestion.
   */
  @Test(expected = NoSuchElementException.class)
  public void removeQuestion() {
    Q1.removeQuestion("q3");
    assertNull(Q1.getQuestion("q3"));
    Q1.removeQuestion("q4");
    assertNull(Q1.getQuestion("q4"));

    Q1.removeQuestion("q10");
  }

  /**
   * Tests getQuestion by index.
   */
  @Test
  public void getQuestionByIndex() {
    assertEquals(q1, Q1.getQuestion(1));
    assertEquals(q2, Q1.getQuestion(2));
    assertEquals(q3, Q1.getQuestion(3));
  }

  /**
   * Tests getQuestion by index exceptions.
   */
  @Test (expected = IndexOutOfBoundsException.class)
  public void getQuestionByIndexException() {
    assertEquals(q1, Q1.getQuestion(10));
    assertEquals(q2, Q1.getQuestion(11));
    assertEquals(q3, Q1.getQuestion(12));
  }

  /**
   * Tests getQuestion by id.
   */
  @Test
  public void getQuestionById() {
    assertEquals(q1, Q1.getQuestion("q1"));
    assertEquals(q2, Q1.getQuestion("q2"));
    assertEquals(q3, Q1.getQuestion("q3"));
  }

  /**
   * Tests getQuestion by id exceptions.
   */
  @Test(expected = NoSuchElementException.class)
  public void getQuestionByIdExceptions() {
    assertEquals(q1, Q1.getQuestion("q10"));
    assertEquals(q2, Q1.getQuestion("q11"));
    assertEquals(q3, Q1.getQuestion("q12"));
  }

  /**
   * Test getRequiredQuestions.
   */
  @Test
  public void getRequiredQuestions() {

    List<Question> requiredList = Arrays.asList(q1, q3);
    assertEquals(requiredList, Q1.getRequiredQuestions());
  }

  /**
   * Test getOptionalQuestions.
   */
  @Test
  public void getOptionalQuestions() {
    List<Question> optionalList = Arrays.asList(q2, q4);
    assertEquals(optionalList, Q1.getOptionalQuestions());
  }

  /**
   * Tests isComplete.
   */
  @Test
  public void isComplete() {
    assertTrue(Q1.isComplete());
  }

  /**
   * Tests getResponses.
   */
  @Test
  public void getResponses() {
    List<String> responseList = Arrays.asList("Yes", "", "Agree", "");
    assertEquals(responseList, Q1.getResponses());
  }

  /**
   * Tests filter.
   */
  @Test
  public void filter() {
  }

  /**
   * Test sort.
   */
  @Test
  public void sort() {
  }

  /**
   * Test fold.
   */
  @Test
  public void fold() {
  }

  /**
   * Tests toString.
   */
  @Test
  public void testToString() {
    System.out.println(Q1.toString());
  }
}