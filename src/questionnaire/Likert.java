package questionnaire;

import java.util.Arrays;
import java.util.List;

public class Likert extends AbstractQuestion {

  public Likert(String prompt, Boolean isRequired) {
    super(prompt, isRequired);
  }

  @Override
  public void answer(String answer) {
    List<LikertResponseOption> answerList
            = Arrays.stream(LikertResponseOption.values())
            .filter(r -> answer.equalsIgnoreCase(r.getText())).toList();
    if(!answerList.isEmpty()) {
      super.answer(answerList.get(0).getText());
    }
  }
}
