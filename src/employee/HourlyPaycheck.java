package employee;

import java.text.DecimalFormat;

public class HourlyPaycheck extends abstractPaycheck implements IPaycheck {

  private double hoursWorked;
  public HourlyPaycheck(double payRate, double hoursWorked) throws IllegalArgumentException {
    super(payRate);

    if (hoursWorked < 0){
      throw new IllegalArgumentException("Hours worked can't be negative");
    }

    this.hoursWorked = hoursWorked;
  }

  public double getHoursWorked() {
    return this.hoursWorked;
  }

  public void addHoursWorked(double hoursAdded){

    this.hoursWorked += hoursAdded;
    if(this.hoursWorked < 0){
      this.hoursWorked = 0;
    }
  }

  public void resetHoursWorked() {
    this.hoursWorked = 0.0;
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
