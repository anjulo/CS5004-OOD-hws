package hw2;

/**
 * Locker class.
 */
public class Locker {

  private double maxWidth;
  private double maxHeight;
  private double maxDepth;
  private MailItem mailItem;

  /**
   * Constructor for Locker class.
   *
   * @param maxWidth  the width of the locker.
   * @param maxHeight the height of the locker.
   * @param maxDepth  the depth of the locker.
   * @throws IllegalArgumentException  illegal argument exception
   */
  public Locker(double maxWidth, double maxHeight, double maxDepth)
                                                        throws IllegalArgumentException {

    if (maxWidth < 1 || maxHeight < 1 || maxDepth < 1) {
      throw new IllegalArgumentException("Arguments can't be negative.");
    }

    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    this.mailItem = null;
  }

  /**
   * Method to add a new mail.
   *
   * @param mailItem the mail item
   */
  public void addMail(MailItem mailItem) {
    if (this.mailItem == null && this.maxWidth >= mailItem.getWidth()
            && this.maxHeight >= mailItem.getHeight() && this.maxDepth >= mailItem.getDepth()) {
      this.mailItem = mailItem;
    }
  }

  /**
   * Picks up and returns the mail item.
   *
   * @param recipient the recipient
   * @return the mail item
   */
  public MailItem pickupMail(Recipient recipient) {
    if (this.mailItem != null && recipient.equals(this.mailItem.getRecipient())) {
      MailItem mailItem1 = this.mailItem;
      this.mailItem = null;
      return mailItem1;
    } else {
      return null;
    }
  }

  /**
   * Getter for the mail item.
   *
   * @param recipient the recipient
   * @return the mail item
   */
  // helper method
  public MailItem getMail(Recipient recipient) {
    if (this.mailItem != null && recipient.equals(this.mailItem.getRecipient())) {
      return this.mailItem;
    } else {
      return null;
    }
  }

}
