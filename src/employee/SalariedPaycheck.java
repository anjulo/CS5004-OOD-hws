package employee;

public class SalariedPaycheck extends abstractPaycheck implements IPaycheck {

  private int payInterval; //(1, 2 or 4)
  public SalariedPaycheck(double payRate, int payInterval) throws IllegalArgumentException {
    super(payRate);
    this.payInterval = payInterval;
  }

  public double getTotalPay(){
    return (payRate/52 * payInterval);
  }

  @Override
  public double getPayAfterTaxes(){
    return 0;
  }


}
