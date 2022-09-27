package hw2;

public class MailItem {

  private double width;
  private double height;
  private double depth;
  private Recipient recipient;

  public MailItem(double width, double height, double depth, Recipient recipient)
                                                throws IllegalArgumentException{
    if (width < 1 || height < 1 || depth < 1){
      throw new IllegalArgumentException("Mail dimensions can't be less than 1");
    }
    else if (recipient == null){
      throw new IllegalArgumentException("Recipient can't be null");
    }

    this.width = width;
    this.height = height;
    this.depth = depth;
    this.recipient = recipient;
  }

  public Recipient getRecipient(){
    return this.recipient;
  }
  public double getWidth(){
    return this.width;
  }
  public double getHeight(){
    return this.height;
  }
  public double getDepth(){
    return this.depth;
  }
}
