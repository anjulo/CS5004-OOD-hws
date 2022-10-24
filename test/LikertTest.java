import org.junit.Before;
import org.junit.Test;

import questionnaire.Question;
import questionnaire.Likert;

import static org.junit.Assert.*;

public class LikertTest {

  Question q1;
  Question q2;
  Question q3;
  Question q4;
  Question q5;
  Question q6;
  Question q7;
  Question q8;
  Question q9;
  Question q10;
  Question q11;
  Question q12;
  Question q13;
  Question q14;
  Question q15;


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

    q11 = new Likert("Annie, are you okay?", true);
    q12 = new Likert("Are you okay, Annie?", false);
    q13 = new Likert("Will you tell us that you're okay?", true);
    q14 = new Likert("So, Annie, are you okay?", false);
    q15 = new Likert("Annie, Okay?", true);
  }

  @Test
  public void answer() {

  }

  @org.junit.Test
  public void getAnswer() {
    q1.answer("Strongly Agree");
    assertEquals("Strongly Agree",q1.getAnswer());
    q2.answer("Agree");
    assertEquals("Agree", q2.getAnswer());
    q3.answer("Neither Agree nor Disagree");
    assertEquals("Neither Agree Nor Disagree", q3.getAnswer());
    q4.answer("Disagree");
    assertEquals("Disagree", q4.getAnswer());
    q5.answer("Strongly Disagree");
    assertEquals("Strongly Disagree", q5.getAnswer());

    q6.answer("sTRONGLY aGREE");
    assertEquals("Strongly Agree",q6.getAnswer());
    q7.answer("AGRee");
    assertEquals("Agree", q7.getAnswer());
    q8.answer("NEITHER agree NOR disagree");
    assertEquals("Neither Agree Nor Disagree", q8.getAnswer());
    q9.answer("disAGREE");
    assertEquals("Disagree", q9.getAnswer());
    q10.answer("sTrOnGlY DiSaGrEe");
    assertEquals("Strongly Disagree", q10.getAnswer());

    q11.answer("Strongly Agree.");
    assertNotEquals("Strongly Agree", q11.getAnswer());
    q12.answer("Agreee");
    assertNotEquals("Agree", q12.getAnswer());
    q13.answer("Neither Agree no Disagree");
    assertNotEquals("Neither Agree Nor Disagree", q13.getAnswer());
    q14.answer("Disagre");
    assertNotEquals("Disagree", q14.getAnswer());
    q15.answer("Strongly Disagree!");
    assertNotEquals("Strongly Disagree", q15.getAnswer());

  }
}