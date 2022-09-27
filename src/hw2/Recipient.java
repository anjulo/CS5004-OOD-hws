package hw2;

public class Recipient {

  private String firstName;
  private String lastName;
  private String email;

  public Recipient(String firstName, String lastName, String email) throws IllegalArgumentException{
    if (firstName == null || lastName == null || email ==null){
      throw new IllegalArgumentException("Arguments can't be null");
    }
    else if (firstName == "" || lastName == "" || email == ""){
      throw new IllegalArgumentException("Arguments can't be empty");
    }

    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  @Override
  public String toString(){
    String str = String.format("%s %s Email:%s", firstName, lastName, email);
    return str;
  }
}
