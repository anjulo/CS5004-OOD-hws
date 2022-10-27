import java.util.function.Predicate;

import questionnaire.Question;

/**
 * The type Long prompt.
 */
public class longPrompt implements Predicate<Question> {

  /**
   * The constant for cut-off length.
   */
  public static final int MIN_LENGTH = 16;

  @Override
  public boolean test(Question q){
    return q.getPrompt().length() > MIN_LENGTH;
  }
}
