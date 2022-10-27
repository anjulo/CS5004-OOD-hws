import java.util.function.BiFunction;
import questionnaire.Question;

/**
 * Implementation of bifunction that give total number of quesitons
 * that are required.
 */
public class totalNumWithResponse implements BiFunction<Question, Integer, Integer> {

  @Override
  public Integer apply(Question q, Integer i) {
    if (q.isRequired()) {
      return i + 1;
    }
    return i;
  }

}
