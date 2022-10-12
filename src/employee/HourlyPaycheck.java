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

  @Override
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
}
