package questionnaire;

import java.util.Objects;

/**
 * The Abstract question class.
 */
public abstract class AbstractQuestion implements Question {

  private final String prompt;
  private final Boolean isRequired;
  private String answer;

  /**
   * Instantiates a new Abstract question.
   *
   * @param prompt     the prompt
   * @param isRequired  required or not
   */
  public AbstractQuestion(String prompt, Boolean isRequired) throws IllegalArgumentException {
    if ( prompt == null || prompt.length() == 0) {
      throw new IllegalArgumentException();
    }
    this.prompt = prompt;
    this.isRequired = isRequired;
    this.answer = "";
  }

  /**
   * Getter for question prompt.
   *
   * @return prompt
   */
  public  String getPrompt() {
    return this.prompt;
  }

  /**
   * Getter for isRequired attribute.
   *
   * @return isRequired.
   */
  public Boolean isRequired() {
    return this.isRequired;
  }

  /**
   * Setter for answer attribute.
   *
   * @param answer the answer
   */
  public void answer(String answer) {
    this.answer = answer;
  }

  /**
   * Getter for answer.
   *
   * @return answer.
   */
  public String getAnswer() {
    if (this.answer == null) {
      return "";
    }
    return this.answer;
  }

  @Override
  public String toString() {
    return "Question: "
            + this.getPrompt()
            + "\n\n"
            + "Answer: "
            + this.getAnswer();
  }
}
