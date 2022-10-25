package questionnaire;

public class ShortAnswer extends AbstractQuestion {

  public ShortAnswer(String prompt, Boolean isRequired){
    super(prompt, isRequired);
  }

  @Override
  public void answer(String answer){
    if(answer.length() <= 280){
      super.answer(answer);
    }
  }
}
