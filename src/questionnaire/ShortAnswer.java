package questionnaire;

import java.util.Objects;

public class ShortAnswer extends AbstractQuestion {

  public ShortAnswer(String prompt, Boolean isRequired){
    super(prompt, isRequired);
  }

  @Override
  public void answer(String answer){
    if(answer.length() <= 280){
      super.answer(answer);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ShortAnswer)) {
      return false;
    }
    ShortAnswer that = (ShortAnswer) o;
    return getPrompt().equals(that.getPrompt())
            && this.isRequired().equals(that.isRequired()
            && this.getAnswer().equals(that.getAnswer()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPrompt(), this.isRequired(), this.getAnswer());
  }

}
