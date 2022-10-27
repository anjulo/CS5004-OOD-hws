import java.util.function.Predicate;

import questionnaire.Question;

public class longPrompt implements Predicate<Question> {

  public static final int MIN_LENGTH = 16;

  @Override
  public boolean test(Question q){
    return q.getPrompt().length() > MIN_LENGTH;
  }
}
