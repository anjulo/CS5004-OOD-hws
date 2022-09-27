package hw2;

public class Locker {

  private double maxWidth;
  private double maxHeight;
  private double maxDepth;
  private MailItem mailItem;

  public Locker(double maxWidth, double maxHeight, double maxDepth) throws IllegalArgumentException{

    if ( maxWidth < 1|| maxHeight < 1 || maxDepth < 1){
      throw new IllegalArgumentException(" Arguments can't be negative.");
    }

    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    this.mailItem = null;
  }

  public void addMail(MailItem mailItem){
    if ( this.mailItem == null && this.maxWidth > mailItem.getWidth() &&
            this.maxHeight > mailItem.getHeight() && this.maxDepth > mailItem.getDepth() ){
      this.mailItem = mailItem;
    }
  }

  public MailItem pickUpMail(Recipient recipient){
    if(this.mailItem != null && recipient.equals(this.mailItem.getRecipient())){
      MailItem mailItem1 = this.mailItem;
      this.mailItem = null;
      return mailItem1;
    }
    else{
      return null;
    }
  }
}
