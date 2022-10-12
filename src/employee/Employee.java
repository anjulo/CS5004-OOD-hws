package employee;

public class Employee {

  private String name;
  private String id;
  private double payRate;
  private int payInterval;
  private boolean isManager;
  private double hoursWorked;
  private boolean isSalaried;
  public Employee(String name, String id, double payRate, int payInterval, boolean isManager )
                      throws IllegalArgumentException{

    if(name == null || name.length() == 0){
      throw new IllegalArgumentException("Invalid employee name!");
    }
    if(id == null || id.length() == 0){
      throw new IllegalArgumentException("Invalid employee ID!");
    }
    if(payRate < 0){
      throw new IllegalArgumentException("Negative pay rate! ");
    }

    this.name = name;
    this.id = id;
    this.payRate = payRate;
    this.payInterval = payInterval;
    this.isSalaried = true;
    this.isManager = isManager;
  }

  public Employee(String name, String id, double payRate, double hoursWorked)
                    throws IllegalArgumentException {

    if(name == null || name.length() == 0){
      throw new IllegalArgumentException("Invalid employee name!");
    }
    if(id == null || id.length() == 0){
      throw new IllegalArgumentException("Invalid employee ID!");
    }
    if(payRate < 0){
      throw new IllegalArgumentException("Negative pay rate! ");
    }
    if(hoursWorked < 0){
      throw new IllegalArgumentException("Negative worked hours!");
    }
    this.name = name;
    this.id = id;
    this.payRate = payRate;
    this.hoursWorked = hoursWorked;
    this.isSalaried = false;
    this.isManager = false;
  }

  public boolean isManager(){
    return this.isManager;
  }

  public IPaycheck getPaycheck(){
    if(isSalaried ){
      return new SalariedPaycheck(payRate, payInterval);
    }
    else{
      return new HourlyPaycheck(payRate, hoursWorked);
    }
  }

  public String toString() {
    String firstLine = String.format("Name: %s", this.name);
    String secondLine = String.format("ID: %s", this.id);
    String thirdLine = this.getPaycheck().toString();
    return (firstLine + "\n" + secondLine + "\n" + thirdLine);
  }
}
