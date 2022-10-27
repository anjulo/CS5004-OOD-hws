import java.util.Comparator;

import questionnaire.Question;

/**
 * Comparator class for questionnaire.
 */
public class promptComparator implements Comparator<Question> {
  /**
   * Returns integer value as a result of comparison.
   * @param q1 the first object to be compared.
   * @param q2 the second object to be compared.
   * @return int
   */
  public int compare(Question q1, Question q2) {
    return Integer.compare(q1.getPrompt().length(), q2.getPrompt().length());
    //return q1.getPrompt().compareTo(q2.getPrompt());
  }
}
