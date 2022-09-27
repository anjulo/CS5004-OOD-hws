package hw2;

import java.util.Objects;

/**
 * Class for the Recipient.
 */
public class Recipient {

  private String firstName;
  private String lastName;
  private String email;

  /**
   * Instantiates a new Recipient.
   *
   * @param firstName the first name of the recipient
   * @param lastName  the last name of the recipient
   * @param email     the email of the recipient
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Recipient(String firstName, String lastName, String email)
                                                       throws IllegalArgumentException {
    if (firstName == null || lastName == null || email == null) {
      throw new IllegalArgumentException("Arguments can't be null");
    } else if (firstName == "" || lastName == "" || email == "") {
      throw new IllegalArgumentException("Arguments can't be empty");
    }

    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  @Override
  public String toString() {
    String str = String.format("%s %s Email:%s", firstName, lastName, email);
    return str;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Recipient)) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    return firstName.equals(recipient.firstName) && lastName.equals(recipient.lastName)
                                                 && email.equals(recipient.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, email);
  }
}
