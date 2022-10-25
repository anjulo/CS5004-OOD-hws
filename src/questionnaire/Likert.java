package questionnaire;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Likert)) {
      return false;
    }
    Likert that = (Likert) o;
    return getPrompt().equals(that.getPrompt())
            && this.isRequired().equals(that.isRequired()
            && this.getAnswer().equals(that.getAnswer()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getPrompt(), this.isRequired(), this.getAnswer());
  }
}
