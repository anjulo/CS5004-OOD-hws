package hw2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class testMailItem {

  private Recipient tom;
  private Recipient jerry;
  private MailItem shoes;
  private MailItem cheese;


  @Before
  public void setUp() throws Exception {
    tom = new Recipient("Thomas", "Cat", "tom@tomandjerry.com");

    jerry = new Recipient("Gerald", "Mouse", "jerry@tomandjerry.com");
    shoes = new MailItem(4.5,2,3,tom);
    cheese = new MailItem(1.0,1.5,1.2, jerry);

  }

  @Test
  public void getRecipient() {
    assertEquals(tom, shoes.getRecipient());
    assertEquals(jerry, cheese.getRecipient());
  }

  @Test
  public void getWidth() {
  }

  @Test
  public void getHeight() {
  }

  @Test
  public void getDepth() {
  }
}