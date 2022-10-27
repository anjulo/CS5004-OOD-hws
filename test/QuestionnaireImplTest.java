import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


import java.util.Arrays;
import java.util.Comparator;
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
   * Questionnaire 3.
   */
  Questionnaire Q3;

  /**
   * Questionnaire 3.
   */
  Questionnaire Q4;

  /**
   * Questionnaire 5.
   */
  Questionnaire Q5;


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

    // questions
    q1 = new YesNo("Annie, are you okay?", true);
    q1.answer("Yes");
    q2 =  new ShortAnswer("explain yourself?", false);
    q3 = new Likert("So, you're okay?", true);
    q3.answer("Agree");
    q4 = new YesNo("yeap?", false);
    q5 = new ShortAnswer("Nope?", true);
    Q2 = new QuestionnaireImpl();

    // questionnaires
    Q1 = new QuestionnaireImpl();
    Q1.addQuestion("q1", q1);
    Q1.addQuestion("q2", q2);
    Q1.addQuestion("q3", q3);
    Q1.addQuestion("q4", q4);

    Q2.addQuestion("q2", q1);
    Q2.addQuestion("q4", q2);
    Q2.addQuestion("q5", q5);
    Q2.addQuestion("q3", q3);

    Q3 = new QuestionnaireImpl();
  }

  /**
   * Tests addQuestion.
   */
  @Test
  public void addQuestion() {
    q5 = new YesNo("Tired of testing?", false);
    q6 = new ShortAnswer("How bad is it?", true);
    q6.answer("I'm telling you it bananas.");

    Q1.addQuestion("q5", q5);
    Q1.addQuestion("q6", q6);

    assertEquals(q5, Q1.getQuestion("q5"));
    assertEquals(q6, Q1.getQuestion("q6"));
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
    Q1.addQuestion(null, q6);
  }

  /**
   * Tests removeQuestion.
   */
  @Test(expected = NoSuchElementException.class)
  public void removeQuestion() {
    Q1.removeQuestion("q3");
    Q1.getQuestion("q3");
    Q1.removeQuestion("q4");
    Q1.getQuestion("q4");

    Q1.removeQuestion("q10");
    Q1.removeQuestion("aha");

    Q3.removeQuestion("lol");
    Q3.removeQuestion("jaja");
  }
  @Test(expected = IllegalArgumentException.class)
  public void removeQuestionArgumentException() {
    Q1.removeQuestion("");
    Q1.removeQuestion(null);
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
    Q1.getQuestion(10);
    Q1.getQuestion(11);
    Q1.getQuestion(12);

    Q3.getQuestion(0);
    Q3.getQuestion(1);
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
    Q1.getQuestion("q10");
    Q1.getQuestion("q11");
    Q1.getQuestion("hello");

    Q3.getQuestion("lol");
    Q3.getQuestion("jaja");
  }

  /**
   * Test getRequiredQuestions.
   */
  @Test
  public void getRequiredQuestions() {

    q5 = new YesNo("Tired of testing?", false);
    q6 = new ShortAnswer("How bad is it?", true);
    q6.answer("I'm telling you it bananas.");

    Q1.addQuestion("q5", q5);
    Q1.addQuestion("q6", q6);

    List<Question> requiredListQ1 = Arrays.asList(q1, q3, q6);
    assertEquals(requiredListQ1, Q1.getRequiredQuestions());

    List<Question> requiredListQ3 = Arrays.asList();
    assertEquals(requiredListQ3, Q3.getRequiredQuestions());

    Q3.addQuestion("q5", q5);
    Q3.addQuestion("q2", q2);
    Q3.addQuestion("q4", q4);

    requiredListQ3 = Arrays.asList();
    assertEquals(requiredListQ3, Q3.getRequiredQuestions());
  }

  /**
   * Test getOptionalQuestions.
   */
  @Test
  public void getOptionalQuestions() {
    q5 = new YesNo("Tired of testing?", false);
    q6 = new ShortAnswer("How bad is it?", true);
    q6.answer("I'm telling you it bananas.");

    Q1.addQuestion("q5", q5);
    Q1.addQuestion("q6", q6);

    List<Question> requiredListQ1 = Arrays.asList(q2, q4, q5);
    assertEquals(requiredListQ1, Q1.getOptionalQuestions());

    List<Question> requiredListQ3 = Arrays.asList();
    assertEquals(requiredListQ3, Q3.getOptionalQuestions());

    Q3.addQuestion("q6", q6);
    Q3.addQuestion("q1", q1);
    Q3.addQuestion("q3", q3);

    requiredListQ3 = Arrays.asList();
    assertEquals(requiredListQ3, Q3.getOptionalQuestions());
  }

  /**
   * Tests isComplete.
   */
  @Test
  public void isComplete() {
    assertTrue(Q1.isComplete());
    assertFalse(Q2.isComplete());
    assertFalse(Q3.isComplete());
  }

  /**
   * Tests getResponses.
   */
  @Test
  public void getResponses() {
    List<String> responseListQ1 = Arrays.asList("Yes", "", "Agree", "");
    List<String> responseListQ2 = Arrays.asList("Yes", "", "", "Agree");
    List<String> responseListQ3 = Arrays.asList();

    assertEquals(responseListQ1, Q1.getResponses());
    assertEquals(responseListQ2, Q2.getResponses());
    assertEquals(responseListQ3, Q3.getResponses());
  }

  /**
   * Tests filter.
   */
  @Test
  public void filter() {
    Q4 = Q1.filter(new isRequired());
    Q5 = new QuestionnaireImpl();
    Q5.addQuestion("q1", q1);
    Q5.addQuestion("q3", q3);
    assertEquals(Q5, Q4);

    Q4 = Q1.filter(new longPrompt());
    Q5 = new QuestionnaireImpl();
    Q5.addQuestion("q1", q1);
    Q5.addQuestion("q2", q2);
    assertEquals(Q5, Q4);
  }

  /**
   * Test sort.
   */
  @Test
  public void sort() {

    Q1.sort(new promptComparator());

    Q4 = new QuestionnaireImpl();
    Q4.addQuestion("q4", q4);
    Q4.addQuestion("q3", q3);
    Q4.addQuestion("q2", q2);
    Q4.addQuestion("q1", q1);

    assertEquals(Q1, Q4);

    Q5 = new QuestionnaireImpl();
    Q5.addQuestion("q3", q3);
    Q5.addQuestion("q4", q4);
    Q5.addQuestion("q2", q2);
    Q5.addQuestion("q1", q1);

    assertNotEquals(Q1, Q5);
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
    System.out.println(Q3.toString());

    String stringQ1 = """
            Question: Annie, are you okay?

            Answer: Yes

            Question: explain yourself?

            Answer:\s

            Question: So, you're okay?

            Answer: Agree

            Question: yeap?

            Answer:\s""";

    String stringQ2 = """
            Question: Annie, are you okay?

            Answer: Yes

            Question: explain yourself?

            Answer:\s

            Question: Nope?

            Answer:\s

            Question: So, you're okay?

            Answer: Agree""";

    assertEquals(stringQ1, Q1.toString());
    assertEquals(stringQ2, Q2.toString());
    assertEquals("", Q3.toString());
  }
}