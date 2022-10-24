package questionnaire;

public interface Question {

  String getPrompt();

  Boolean isRequired();

  void answer(String answer);

  String getAnswer();

  Question copy() throws CloneNotSupportedException;

}
