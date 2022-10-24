import org.junit.Before;
import org.junit.Test;

import questionnaire.Question;
import questionnaire.ShortAnswer;
import questionnaire.YesNo;

import static org.junit.Assert.*;

public class ShortAnswerTest {

  Question q1;
  Question q2;
  Question q3;
  Question q4;

  @Before
  public void setUp() throws Exception {
    q1 = new ShortAnswer("Annie, are you okay?", true);
    q2 = new ShortAnswer("Are you okay, Annie?", false);
    q3 = new ShortAnswer("Will you tell us that you're okay?", false);
    q4 = new ShortAnswer("So, Annie, are you okay?", true);
  }

  @Test
  public void answer() {
  }

  @org.junit.Test
  public void getAnswer() {
    String answer2 = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium " +
                     "doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore "+
                     "veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim " +
                     "ipsam voluptatem quia voluptas sit aspernatur aut odit";

    String answer3 = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium " +
                     "doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore "+
                     "veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim " +
                     "ipsam voluptatem quia voluptas sit aspernatur aut odit.";

    String answer4 = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium " +
                     "doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore "+
                     "veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim " +
                     "ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia " +
                     "consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque "+
                     "porro quisquam est, qui";

    System.out.println(answer2.length());
    System.out.println(answer3.length());

    q1.answer("Yes");
    q2.answer(answer2);
    q3.answer(answer3);
    q4.answer(answer4);

    assertEquals("Yes", q1.getAnswer());
    assertEquals(answer2, q2.getAnswer());
    assertEquals("", q3.getAnswer());
    assertEquals("", q4.getAnswer());
  }
}