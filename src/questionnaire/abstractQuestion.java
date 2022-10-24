package questionnaire;

import java.util.Objects;

public abstract class abstractQuestion implements Question, Cloneable{

  private final String prompt;
  private final Boolean isRequired;
  private String answer = "";

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

  public String getAnswer(){
    return this.answer;
  }

  public Question copy() throws CloneNotSupportedException {
   return (Question) super.clone();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof abstractQuestion that)) return false;
    return getPrompt().equals(that.getPrompt()) && isRequired.equals(that.isRequired);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPrompt(), isRequired);
  }
}
