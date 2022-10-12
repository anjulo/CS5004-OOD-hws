package employee;

/**
 * The paycheck class for salaried employees.
 */
public class SalariedPaycheck extends abstractPaycheck implements IPaycheck {

  private int payInterval; //(1, 2 or 4)

  /**
   * Instantiates a new SalariedPaycheck object.
   *
   * @param payRate     the pay rate
   * @param payInterval the pay interval
   * @throws IllegalArgumentException exception for illegal pay interval
   */
  public SalariedPaycheck(double payRate, int payInterval) throws IllegalArgumentException {

    super(payRate);
    if (!(payInterval == 1 || payInterval == 2 || payInterval == 4)) {
      throw new IllegalArgumentException("Pay interval should 1, 2 or 4!");
    }
    this.payInterval = payInterval;
  }

  @Override
  public double getTotalPay() {
    return (payRate / 52 * payInterval);
  }
}
