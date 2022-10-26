package questionnaire;

import java.util.Objects;

public class YesNo extends AbstractQuestion {

  public YesNo(String prompt, Boolean isRequired){
    super(prompt, isRequired);
  }

  @Override
  public void answer(String answer){
    if (answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("No")){
      super.answer(answer);
    }
  }

  public Question copy(){
    Question newQuestion = new YesNo(this.getPrompt(), this.isRequired());
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
    if (!(o instanceof YesNo)) {
      return false;
    }
    YesNo that = (YesNo) o;
    return getPrompt().equals(that.getPrompt())
            && this.isRequired().equals(that.isRequired()
            && this.getAnswer().equals(that.getAnswer()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPrompt(), this.isRequired(), this.getAnswer());
  }
}
