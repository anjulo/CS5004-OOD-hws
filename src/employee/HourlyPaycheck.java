package employee;

import java.util.Objects;

/**
 * The paycheck class for hourly paid employees.
 */
public class HourlyPaycheck extends abstractPaycheck implements IPaycheck {

  private double hoursWorked;

  /**
   * Instantiates a new HourlyPaycheck.
   *
   * @param payRate     the pay rate
   * @param hoursWorked the hours worked
   * @throws IllegalArgumentException exception for negative hours
   */
  public HourlyPaycheck(double payRate, double hoursWorked) throws IllegalArgumentException {
    super(payRate);
    if (hoursWorked < 0) {
      throw new IllegalArgumentException("Hours worked can't be negative");
    }
    this.hoursWorked = hoursWorked;
  }

  /**
   * Gets hours worked.
   *
   * @return the hours worked
   */
  public double getHoursWorked() {
    return this.hoursWorked;
  }

  /**
   * Add hours worked.
   *
   * @param hoursAdded the hours added
   */
  public void addHoursWorked(double hoursAdded) {

    this.hoursWorked += hoursAdded;
    if (this.hoursWorked < 0) {
      this.hoursWorked = 0;
    }
  }

  /**
   * Reset hours worked.
   */
  public void resetHoursWorked() {
    this.hoursWorked = 0.0;
  }

  @Override
  public double getTotalPay() {
    double totalPay;
    final double WORK_WEEK = 40.0;
    final double OVER_TIME = 1.5;
    if (this.hoursWorked <= WORK_WEEK) {
      totalPay = this.hoursWorked * this.getPayRate();
    } else {
      totalPay = (WORK_WEEK + (this.hoursWorked - WORK_WEEK) *  OVER_TIME) * this.getPayRate();
    }
    return totalPay;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof HourlyPaycheck)) {
      return false;
    }
    HourlyPaycheck that = (HourlyPaycheck) o;
    return (Double.compare(that.getHoursWorked(), getHoursWorked()) == 0
            && Double.compare(that.getPayRate(), getPayRate()) == 0);
  }


  @Override
  public int hashCode() {
    return Objects.hash(getHoursWorked());
  }

}
