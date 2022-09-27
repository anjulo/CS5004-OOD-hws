package hw2;

/**
 * MailItem class.
 */
public class MailItem {

  private double width;
  private double height;
  private double depth;
  private Recipient recipient;

  /**
   * Constructor for a new Mailitem object.
   *
   * @param width     the width of the item
   * @param height    the height of the item
   * @param depth     the depth of the item
   * @param recipient the recipient of the item.
   * @throws IllegalArgumentException the illegal argument exception
   */
  public MailItem(double width, double height, double depth, Recipient recipient)
                                                throws IllegalArgumentException {
    if (width < 1 || height < 1 || depth < 1) {
      throw new IllegalArgumentException("Mail dimensions can't be less than 1");
    } else if (recipient == null) {
      throw new IllegalArgumentException("Recipient can't be null");
    }

    this.width = width;
    this.height = height;
    this.depth = depth;
    this.recipient = recipient;
  }

  /**
   * Returns the recipient of the item.
   *
   * @return the recipient
   */
  public Recipient getRecipient() {
    return this.recipient;
  }

  /**
   * Returns the width of the mail item.
   *
   * @return double width
   */
  public double getWidth() {
    return this.width;
  }

  /**
   * Returns the height of the mail item.
   *
   * @return double height
   */
  public double getHeight() {
    return this.height;
  }

  /**
   * Returns the depth of the mail item.
   *
   * @return double depth
   */
  public double getDepth() {
    return this.depth;
  }
}
