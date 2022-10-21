package questionnaire;

public interface Question {

  String getPrompt();

  Boolean isRequired();

  void answer(String response);

  String getAnswer();

  Question Copy();

}
