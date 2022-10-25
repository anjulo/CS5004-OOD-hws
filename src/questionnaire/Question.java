package questionnaire;

/**
 * The Question interface.
 */
public interface Question {

  /**
   * Gets the question prompt.
   *
   * @return the prompt
   */
  String getPrompt();

  /**
   * Checks if the question is required.
   *
   * @return the boolean
   */
  Boolean isRequired();

  /**
   * Sets the answer to the input string.
   *
   * @param answer the answer
   */
  void answer(String answer);

  /**
   * Gets answer of the question.
   *
   * @return the answer
   */
  String getAnswer();

  /**
   * implements deep copy of question.
   *
   * @return the question
   * @throws CloneNotSupportedException the clone not supported exception
   */
  Question copy() throws CloneNotSupportedException;

}
