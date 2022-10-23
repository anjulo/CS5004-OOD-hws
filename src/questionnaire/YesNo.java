package questionnaire;

public class YesNo extends abstractQuestion{

  public YesNo(String prompt, Boolean isRequired){
    super(prompt, isRequired);
  }

  @Override
  public void answer(String answer){
    if(answer.equalsIgnoreCase("Yes")
            || answer.equalsIgnoreCase("No")){
      super.answer(answer);
    }

  }

}
