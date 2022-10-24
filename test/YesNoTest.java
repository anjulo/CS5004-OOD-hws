import org.junit.Before;
import org.junit.Test;

import questionnaire.*;

import static org.junit.Assert.*;

public class YesNoTest {

  Question q1;
  Question q2;
  Question q3;
  Question q4;
  Question q5;

  @Before
  public void setUp() throws Exception {
    q1 = new YesNo("Annie, are you okay?", true);
    q2 = new YesNo("Are you okay, Annie?", false);
    q3 = new YesNo("Will you tell us that you're okay?", false);
    q4 = new YesNo("So, Annie, are you okay?", true);
    q5 = new YesNo("Annie, Okay?", false);
  }

  @Test
  public void answer() {
   // do i need to implement this?
  }

  @org.junit.Test
  public void getAnswer() {

    q1.answer("Yes");
    q2.answer("No");
    q3.answer("yes");
    q4.answer("no");
    q5.answer("Yeap");

    assertEquals(q1.getAnswer(), "Yes");
    assertEquals(q2.getAnswer(), "No");
    assertEquals(q3.getAnswer(), "Yes");
    assertEquals(q4.getAnswer(), "No");
    assertEquals(q5.getAnswer(), "");

  }
}