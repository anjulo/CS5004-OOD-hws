package questionnaire;

import java.util.Objects;

/**
 * The type Short answer.
 */
public class ShortAnswer extends AbstractQuestion {

  /**
   * Instantiates a new Short answer.
   *
   * @param prompt     the prompt
   * @param isRequired the is required
   */
  public ShortAnswer(String prompt, Boolean isRequired) {
    super(prompt, isRequired);
  }

  @Override
  public void answer(String answer) throws IllegalArgumentException {
    final int MaxNumOfChar = 280;
    if (answer != null && answer.length() <= MaxNumOfChar) {
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
    Question newQuestion = new ShortAnswer(this.getPrompt(), this.isRequired());
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
    if (!(o instanceof ShortAnswer)) {
      return false;
    }
    ShortAnswer that = (ShortAnswer) o;
    return this.getPrompt().equals(that.getPrompt())
            && this.isRequired().equals(that.isRequired()
            && this.getAnswer().equals(that.getAnswer()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPrompt(), this.isRequired(), this.getAnswer());
  }

}
