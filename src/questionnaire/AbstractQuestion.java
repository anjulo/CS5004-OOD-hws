package questionnaire;

import java.util.Objects;

public abstract class AbstractQuestion implements Question, Cloneable{

  private final String prompt;
  private final Boolean isRequired;
  private String answer = "";

  public AbstractQuestion(String prompt, Boolean isRequired){
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

  public String getAnswer(){
    return this.answer;
  }

  public Question copy() throws CloneNotSupportedException {
   return (Question) super.clone();
  }
  @Override
  public String toString(){
    return "Question: " +this.getPrompt() +
            "\n \n" +
            "Answer: " + this.getAnswer() +
            "\n \n";
  }
}
