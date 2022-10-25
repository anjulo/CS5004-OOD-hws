package questionnaire;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class QuestionnaireImpl implements Questionnaire{

  public QuestionnaireImpl() {

  }

  public void addQuestion(String identifier, Question q){

  }

  public void removeQuestion(String identifier){

  }

  public Question getQuestion(int num){

    return null;
  }

  public  Question getQuestion(String identifier){

    return null;
  }

  public List<Question> getRequiredQuestions(){

    return null;
  }

  public  List<Question> getOptionalQuestions(){

    return null;
  }

  public boolean isComplete(){

    return false;
  }

  public List<String> getResponses(){

    return null;
  }
  public  Questionnaire filter(Predicate<Question> pq){

    return null;
  }

  public void sort(Comparator<Question> comp){

  }

  public <R> R fold(BiFunction<Question, R, R> bf, R seed){

    return null;
  }

  public  String toString() {

    return null;
  }

}
