package questionnaire;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Likert extends abstractQuestion {

  public Likert(String prompt, Boolean isRequired) {
    super(prompt, isRequired);
  }

  @Override
  public void answer(String answer) {
    List<LikertResponseOption> answerList
            = Arrays.stream(LikertResponseOption.values())
            .filter(r -> answer.equalsIgnoreCase(r.getText())).toList();
    super.answer(answerList.get(0).getText());

  }
}
