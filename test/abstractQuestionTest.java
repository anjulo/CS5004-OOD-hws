import static org.junit.Assert.*;
import questionnaire.*;
import org.junit.Test;
import org.junit.Before;

public class abstractQuestionTest {

  Question q1;
  Question q2;
  Question q3;
  Question q4;

  @Before
  public void setUp() throws Exception {
    q1 = new YesNo("Annie, are you okay?", true);
    q2 = new YesNo("Are you okay, Annie?", false);
    q3 = new YesNo("", false);
    q4 = new YesNo(" ", true);
    q4 = new YesNo(null, false);
  }

  @Test
  public void getPrompt() {
    assertEquals(q1.getPrompt(), "Annie, are you okay?");
    assertEquals(q2.getPrompt(), "Are you okay, Annie?");
    assertEquals(q3.getPrompt(),"");
    assertNull(q4.getPrompt());
  }

  @Test
  public void isRequired() {
    assertTrue(q1.isRequired());
    assertFalse(q2.isRequired());
  }

  @Test
  public void getAnswer(){
    assertEquals(q1.getAnswer(), "");
  }

  @Test
  public void copy() throws CloneNotSupportedException {
    q3 = q1.copy();
    assertTrue(q1.equals(q3) && q1 != q3);
  }
}