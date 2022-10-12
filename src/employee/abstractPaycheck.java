package employee;

import java.text.DecimalFormat;

public abstract class abstractPaycheck implements IPaycheck {

  protected double payRate;

  public abstractPaycheck(double payRate){
    this.payRate = payRate;
  }

  public double getPayRate(){
    return this.payRate;
  }

  public abstract double getTotalPay();

  //@Override
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