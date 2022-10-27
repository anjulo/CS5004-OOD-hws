import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import questionnaire.Question;
import questionnaire.ShortAnswer;


/**
 * Test class for the shortAnswer class.
 */
public class ShortAnswerTest {

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
   * Sets up objects for test.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    q1 = new ShortAnswer("Annie, are you okay?", true);
    q2 = new ShortAnswer("Are you okay, Annie?", false);
    q3 = new ShortAnswer("Will you tell us that you're okay?", false);
    q4 = new ShortAnswer("So, Annie, are you okay?", true);
  }

  /**
   * Test for answer method.
   */
  @Test
  public void answer() {

    String answer2 = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium "
            + "doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore "
            + "veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim "
            + "ipsam voluptatem quia voluptas sit aspernatur aut odit";

    q1.answer("Yes, I'm okay.");
    q2.answer(answer2);
    q3.answer("");
    q4.answer("Duh!");

    assertEquals("Yes, I'm okay.", q1.getAnswer());
    assertEquals(answer2, q2.getAnswer());
    assertEquals("", q3.getAnswer());
    assertEquals("Duh!", q4.getAnswer());
  }

  /**
   * Test exceptions from answer method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void answerExceptions() {
    String answer3 = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium "
            + "doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore "
            + "veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim "
            + "ipsam voluptatem quia voluptas sit aspernatur aut odit.";

    String answer4 = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium "
            + "doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore "
            + "veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim "
            + "ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia "
            + "consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque "
            + "porro quisquam est, qui";

    q1.answer(null);
    q3.answer(answer3);
    q4.answer(answer4);

  }

  /**
   * Test copy() method.
   */
  @Test
  public void copy() {

  }
}