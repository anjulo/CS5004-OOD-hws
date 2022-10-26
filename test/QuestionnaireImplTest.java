import org.junit.Before;
import org.junit.Test;

import java.util.List;

import questionnaire.Questionnaire;
import questionnaire.QuestionnaireImpl;
import questionnaire.YesNo;
import questionnaire.Question;

import static org.junit.Assert.*;


public class QuestionnaireImplTest {

  Questionnaire Q1;
  Questionnaire Q2;

  Question q1;
  Question q2;
  Question q3;
  Question q4;

  @Before
  public void setUp() throws Exception {
    Q1 = new QuestionnaireImpl();

    q1 = new YesNo("yes?", true);
    q1.answer("Yes");
    Q1.addQuestion("yes", q1);

    q2 =  new YesNo("no?", false);
    //q2.answer("No");
    Q1.addQuestion("no",q2);

    q3 = new YesNo("yeah?", true);
    q3.answer("yes");
    Q1.addQuestion("yeah", q3);

    q4 = new YesNo("nope?", false);
    //q4.answer("no");
    Q1.addQuestion("nope", q4);
  }

  @Test
  public void addQuestion() {
    System.out.println(Q1.getQuestion(1));
    System.out.println(Q1.getQuestion("no"));
    System.out.println(Q1.getQuestion(3));
    System.out.println(Q1.getQuestion("nope"));
    //assertEquals()
  }

  @Test
  public void removeQuestion() {
  }

  @Test
  public void getQuestion() {
    //test both functions (overloaded)
  }


  @Test
  public void getRequiredQuestions() {
    System.out.println(Q1.getRequiredQuestions());
  }

  @Test
  public void getOptionalQuestions() {
    System.out.println(Q1.getOptionalQuestions());
  }

  @Test
  public void isComplete() {
    System.out.println(Q1.isComplete());
  }

  @Test
  public void getResponses() {
    System.out.println(Q1.getResponses());
  }

  @Test
  public void filter() {
  }

  @Test
  public void sort() {
  }

  @Test
  public void fold() {
  }

  @Test
  public void testToString() {
    System.out.println(Q1.toString());
  }
}