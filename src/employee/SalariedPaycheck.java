package employee;

import java.util.Objects;

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
    if (payInterval < 1) {
      throw new IllegalArgumentException("Pay interval can't be less than 1!");
    }
    this.payInterval = payInterval;
  }

  @Override
  public double getTotalPay() {
    return (payRate / 52 * payInterval);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SalariedPaycheck )) {
      return false;
    }
    SalariedPaycheck that = (SalariedPaycheck)  o;
    return (payInterval == that.payInterval
              && Double.compare(that.getPayRate(), this.getPayRate()) == 0);
  }


  @Override
  public int hashCode() {
    return Objects.hash(payInterval);
  }

}
