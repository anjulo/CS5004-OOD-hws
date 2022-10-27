package questionnaire;

import java.util.Objects;

/**
 * The YesNo concrete class.
 */
public class YesNo extends AbstractQuestion {

  /**
   * Instantiates a new YesNo object.
   *
   * @param prompt     prompt
   * @param isRequired isRequired
   */
  public YesNo(String prompt, Boolean isRequired) {
    super(prompt, isRequired);
  }

  @Override
  public void answer(String answer) throws IllegalArgumentException {

    if (answer != null  && (answer.equalsIgnoreCase("Yes")
            || answer.equalsIgnoreCase("No"))) {
      super.answer(answer);
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Deep copies the question.
   *
   * @return Question
   */
  public Question copy() {
    Question newQuestion = new YesNo(this.getPrompt(), this.isRequired());
    if (this.getAnswer().length() != 0) {
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
