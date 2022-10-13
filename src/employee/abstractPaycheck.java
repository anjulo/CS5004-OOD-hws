package employee;

import java.text.DecimalFormat;

/**
 * The type Abstract paycheck.
 */
public abstract class abstractPaycheck implements IPaycheck {

  /**
   * The Pay rate class.
   */
  private double payRate;

  /**
   * Instantiates a new Abstract paycheck.
   *
   * @param payRate pay rate
   * @throws IllegalArgumentException exception
   */
  public abstractPaycheck(double payRate) throws IllegalArgumentException {
    if (payRate < 0) {
      throw new IllegalArgumentException("Pay rate can't be negative!");
    }
    this.payRate = payRate;
  }

  /**
   * getter for pay rate.
   *
   * @return payRate
   */
  public double getPayRate() {
    return this.payRate;
  }

  /**
   * Abstract method for getting total pay.
   *
   * @return total pay.
   */
  public abstract double getTotalPay();

  /**
   * returns the pay after taxes are applied.
   *
   * @return pay after tax
   */
  public double getPayAfterTaxes() {
    double totalPay = this.getTotalPay();
    double totalPayAfterTaxes;
    final double ONE_CENT = 0.01;
    // change 400.0, 0.9 and 0.85 into constants?
    if (this.getTotalPay() < 400.0) {
      totalPayAfterTaxes = 0.9 * totalPay;
    } else {
      totalPayAfterTaxes = 0.85 * totalPay;
    }
    // when pay is less than 1 cent
    if (totalPayAfterTaxes > 0.0 && totalPayAfterTaxes <= 0.01) {
      totalPayAfterTaxes = ONE_CENT;
    }
    return totalPayAfterTaxes;
  }

  @Override
  public String toString() {

    DecimalFormat df = new DecimalFormat("$ 0.00");
    return ("Payment after taxes: " + df.format(this.getPayAfterTaxes()));
  }

}