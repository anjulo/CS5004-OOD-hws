package questionnaire;

public abstract class abstractQuestion implements Question{

  private String prompt;
  private Boolean isRequired;
  private String answer;

  public abstractQuestion(String prompt, Boolean isRequired){
    this.prompt = prompt;
    this.isRequired = isRequired;
  }

  public  String getPrompt(){
    return this.prompt;
  }
  public Boolean isRequired(){
    return this.isRequired;
  }

  public void answer(String answer){
    this.answer = answer;
  }

  public  String getAnswer(){
    return this.answer;
  }

  public Question Copy(){

  }

}
