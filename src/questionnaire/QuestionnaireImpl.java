package questionnaire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The concrete implementation of Questionnaire interface.
 */
public class QuestionnaireImpl implements Questionnaire {

  private Map<String, Question> map;

  /**
   * Constructor.
   */
  public QuestionnaireImpl() {
    this.map = new LinkedHashMap<>();
  }

  /**
   * Add a question to the questionnaire.
   *
   * @param identifier a name for the question <b>unique</b> within this questionnaire. Not null
   *                   or empty.
   * @param q the {@link Question} to be added to the questionnaire
   */
  public void addQuestion(String identifier, Question q) throws IllegalArgumentException {
    if (identifier != null && identifier.length() != 0) {
      map.put(identifier, q);
    } else {
      throw new IllegalArgumentException();
    }

  }

  /**
   * Remove the question with the given identifier from the questionnaire.
   *
   * @param identifier the identifier of the question to be removed.
   * @throws NoSuchElementException if there is no question with the given identifier.
   */
  public void removeQuestion(String identifier) throws NoSuchElementException {
    if (map.containsKey(identifier)) {
      map.remove(identifier);
    } else {
      throw new NoSuchElementException();
    }
  }

  /**
   * Get the question with the given number, based on the order in which it was added to the
   * questionnaire, or the sorted order if the {@code sort()} method is called. The first question
   * is 1, second 2, etc.
   *
   * @param num the number of the question, counting from 1
   * @return the question
   * @throws IndexOutOfBoundsException if there is no such question num
   */
  public Question getQuestion(int num) throws IndexOutOfBoundsException {
    String key = this.getKeysList().get(num - 1);
    return map.get(key);
  }

  /**
   * Get the question with the given identifier (question having been previously added to the
   * questionnaire).
   *
   * @param identifier the identifier of the question
   * @return the question
   * @throws NoSuchElementException if there is no question with the identifier
   */
  public  Question getQuestion(String identifier) throws NoSuchElementException {
    if (this.getKeysList().contains(identifier)) {
      return map.get(identifier);
    } else {
      throw new NoSuchElementException();
    }
  }

  /**
   * Return a list of all required questions in the questionnaire.
   *
   * @return the required questions.
   */
  public List<Question> getRequiredQuestions() {

    return this.getQuestionsList()
            .stream()
            .filter(Question::isRequired).collect(Collectors.toList());
  }

  /**
   * Return a list of all optional questions in the questionnaire.
   *
   * @return the optional questions.
   */
  public  List<Question> getOptionalQuestions() {

    return this.getQuestionsList()
            .stream()
            .filter(q -> !q.isRequired())
            .collect(Collectors.toList());
  }

  /**
   * Report if all required questions have some non-empty response.
   *
   * @return true if all required questions have responses, false otherwise.
   */
  public boolean isComplete() {
    List<Question> requiredQuestionsList = this.getRequiredQuestions();
    for (Question q : requiredQuestionsList) {
      if (q.getAnswer().length() == 0) {
        return false;
      }
    }
    return true;
    /*
    List<Question> hasResponse = requiredQuestionsList.stream()
            .filter(q -> (q.getAnswer().length() != 0)).collect(Collectors.toList());



    //return (hasResponse.size() == requiredQuestionsList.size());

     */
  }

  /**
   * Return a list of just the responses to all the questions in the questionnaire.
   *
   * @return the responses
   */
  public List<String> getResponses() {
    return this.getQuestionsList()
            .stream()
            .map(Question::getAnswer)
            //.filter(Objects::nonNull) // answer -> (answer != null)
            .collect(Collectors.toList());

  }

  /**
   * Produce a new questionnaire containing just the questions where the given predicate returns
   * true. The returned questionnaire is completely independent of this questionnaire. That is,
   * the questions in the returned questionnaire are <b>copies</b> of the original questions.
   *
   * @param pq the predicate
   * @return the new questionnaire
   */
  public Questionnaire filter(Predicate<Question> pq) throws NullPointerException {
    if (pq == null) {
      throw new NullPointerException();
    } else {
      QuestionnaireImpl filteredQuestionnaire = new QuestionnaireImpl();
      // change implementation
      filteredQuestionnaire.map = this.getKeysQuestionsList()
              .stream()
              .filter(kq -> pq.test(kq.getValue())) //
              .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                      (x, y) -> y, LinkedHashMap::new));

      return (Questionnaire) filteredQuestionnaire;
    }
  }

  /**
   * Sort the questions according to the given comparator. Return values from
   * {@code getQuestion(int)} should reflect the new sorted order following sort.
   *
   * @param comp a comparator for Question
   */
  public void sort(Comparator<Question> comp) {
    if (comp == null) {
      throw new NullPointerException();
    } else {
      List<Map.Entry<String, Question>> keysQuestionsList = this.getKeysQuestionsList();
      this.map.clear();
      this.map = keysQuestionsList
              .stream()
              .sorted(Map.Entry.comparingByValue(comp)) //
              .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                      (x, y) -> x, LinkedHashMap::new));
    }
  }

  /**
   * Produce a single summary value based on the given folding function and
   * seed value.
   *
   * @param bf the folding function
   * @param seed the seed value
   * @param <R> the return type
   * @return the summary value
   */
  public <R> R fold(BiFunction<Question, R, R> bf, R seed) throws IllegalArgumentException {
    if (bf == null || seed == null) {
      throw new IllegalArgumentException();
    }

    //R result = seed;
    for (Question q : this.getQuestionsList()) {
      seed = bf.apply(q, seed);
    }
    return seed;
    /*
    R foldedValue = questionsList
            .stream()
            .reduce(seed, (a,b) -> bf.apply(b,a));
    return foldedValue;

     */
  }

  /**
   * Convert the questionnaire into a single string in the format of
   * Question: [prompt] then two newlines
   * Answer: [answer] two newlines, and so on. Example result for a questionnaire with 3 questions:
   * Question: What is your name?
   *
   * <p>Answer: Sir Lancelot
   *
   * <p>Question: What is your quest?
   *
   * <p>Answer: I seek the Holy Grail.
   *
   * <p>Question: What is your favorite color?
   *
   * <p>Answer: Blue.
   *
   * @return the questionnaire as a String
   */
  public  String toString() {
    StringBuilder outString = new StringBuilder();
    int i = 0;
    for (Question q : this.getQuestionsList()) {
      outString.append(q.toString());
      if (i++ != this.getQuestionsList().size() - 1) {
        outString.append("\n\n");
      }
    }
    return outString.toString();
  }

  private List<Question> getQuestionsList() {
    return new ArrayList<>(this.map.values());
  }

  private List<String> getKeysList() {
    return new ArrayList<>(this.map.keySet());
  }

  private List<Map.Entry<String, Question>> getKeysQuestionsList() {
    return  new ArrayList<>(this.map.entrySet());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof QuestionnaireImpl)) {
      return false;
    }
    QuestionnaireImpl that = (QuestionnaireImpl)  o;

    return map.equals(that.map) && this.getKeysList().equals(that.getKeysList());
  }

  @Override
  public int hashCode() {
    return Objects.hash(map);
  }
}
