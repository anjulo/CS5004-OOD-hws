package questionnaire;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Likert extends AbstractQuestion {

  public Likert(String prompt, Boolean isRequired) {
    super(prompt, isRequired);
  }

  @Override
  public void answer(String answer) {
    List<LikertResponseOption> answerList
            = Arrays.stream(LikertResponseOption.values())
            .filter(r -> answer.equalsIgnoreCase(r.getText()))
            .collect(Collectors.toList());
    if(!answerList.isEmpty()) {
      super.answer(answerList.get(0).getText());
    }
  }

  public Question copy(){
    Question newQuestion = new Likert(this.getPrompt(), this.isRequired());
    if(this.getAnswer().length() != 0) {
      newQuestion.answer(this.getAnswer());
    }
    return newQuestion;
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
