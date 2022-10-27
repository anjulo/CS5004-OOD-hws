import java.util.function.Predicate;

import questionnaire.Question;

/**
 * predicate implementation for required.
 */
public class isRequired implements Predicate<Question> {

  @Override
  public boolean test(Question q) {
    return q.isRequired();
  }
}
