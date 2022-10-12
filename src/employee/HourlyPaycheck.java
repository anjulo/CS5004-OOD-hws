package employee;

import java.text.DecimalFormat;

public class HourlyPaycheck extends abstractPaycheck implements IPaycheck {

  private double hoursWorked;
  public HourlyPaycheck(double payRate, double hoursWorked) throws IllegalArgumentException {
    super(payRate);
    this.hoursWorked = hoursWorked;
  }

  public void addHoursWorked(double hoursAdded){

    this.hoursWorked += hoursAdded;
    if(this.hoursWorked < 0){
      this.hoursWorked = 0;
    }
  }
  public void resetHoursWorked() {
    this.hoursWorked = 0;
  }

  public double getHoursWorked() {
    return this.hoursWorked;
  }
  public double getTotalPay() {
    double totalPay;
    final double WORK_WEEK = 40.0;
    final double OVER_TIME = 1.5;
    if (this.hoursWorked <= WORK_WEEK) {
      totalPay = this.hoursWorked * this.payRate;
    } else {
      totalPay = (WORK_WEEK + (this.hoursWorked - WORK_WEEK) *  OVER_TIME) * this.payRate;
    }
    return totalPay;
  }

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

  public String toString() {

    DecimalFormat df = new DecimalFormat("$ 0.00");
    return ("Payment after taxes: " + df.format(this.getPayAfterTaxes()));
  }
}
