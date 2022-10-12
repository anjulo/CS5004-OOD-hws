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

}