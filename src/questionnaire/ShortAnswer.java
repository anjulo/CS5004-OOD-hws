package questionnaire;

import java.util.Objects;

public class ShortAnswer extends AbstractQuestion {

  public ShortAnswer(String prompt, Boolean isRequired){
    super(prompt, isRequired);
  }

  @Override
  public void answer(String answer) throws IllegalArgumentException{
    if(answer.length() <= 280){
      super.answer(answer);
    } else {
      throw new IllegalArgumentException();
    }
  }

  public Question copy(){
    Question newQuestion = new ShortAnswer(this.getPrompt(), this.isRequired());
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
