package employee;

/**
 * The interface for the Paycheck classes.
 */
public interface IPaycheck {
  /**
   * Gets total pay.
   *
   * @return the total pay
   */
  double getTotalPay();

  /**
   * Gets pay after taxes.
   *
   * @return the pay after taxes
   */
  double getPayAfterTaxes();

  /**
   * Gets pay rate.
   *
   * @return the pay rate
   */
  double getPayRate();
}
