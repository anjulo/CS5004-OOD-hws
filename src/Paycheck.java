import static java.lang.Math.floor;

import java.text.DecimalFormat;

/**
 * The Paycheck class.
 *
 * @author Bereket Yisehak
 */
public class Paycheck {

  private double payRate;
  private double totalHours;
  private double totalPay;

  /**
   * Instantiates a new Paycheck.
   *
   * @param payRate    the hourly pay rate
   * @param totalHours the total hours worked a week
   */
  public Paycheck(double payRate, double totalHours) {
    this.payRate = payRate;
    this.totalHours = totalHours;
    this.totalPay = this.getTotalPay();
  }

  /**
   * Get the total weekly pay.
   *
   * @return totalpay double
   */
  public double getTotalPay() {
    if (this.totalHours <= 40.0) {
      this.totalPay = this.totalHours * this.payRate;
    } else {
      this.totalPay = (40 + (this.totalHours - 40.0) *  1.5) * this.payRate;
    }

    //double roundedTotalPay = floor(100 * this.totalPay) / 100;
    return this.totalPay;
  }

  /**
   * Get pay after taxes double.
   *
   * @return the double
   */
  public double getPayAfterTaxes() {
    if (this.getTotalPay() < 400.0) {
      this.totalPay -= 0.1 * this.totalPay;
    } else {
      this.totalPay -= 0.15 * this.totalPay;
    }
    if (this.totalPay > 0.0 && this.totalPay < 0.01) {
      this.totalPay = 0.01;
    }

    //maintain fractional cents
    //double roundedPayAfterTaxes = floor(100 * this.totalPay) / 100;
    return this.totalPay;
  }

  /**
   * Returns a string representing the current payment AFTER taxes are assessed.
   *
   * @return String
   */
  public String toString() {

    DecimalFormat df = new DecimalFormat("$ 0.00");
    String outString = "Payment after taxes: " + df.format(this.getPayAfterTaxes());
    return outString;
  }
}
