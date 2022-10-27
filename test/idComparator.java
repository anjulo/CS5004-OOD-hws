import java.util.Comparator;

import questionnaire.Question;

/**
 * Comparator class for questionnaire.
 */
public class idComparator implements Comparator<Question> {
  public int compare(Question q1, Question q2) {
    return Integer.compare(q1.getPrompt().length(), q2.getPrompt().length());
    //return q1.getPrompt().compareTo(q2.getPrompt());
  }
}
