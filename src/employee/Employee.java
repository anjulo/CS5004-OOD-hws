package employee;

/**
 * The Employee class.
 */
public class Employee {

  private String name;
  private String id;
  private boolean isManager;
  private IPaycheck paycheck;

  /**
   * Instantiates a new Employee.
   *
   * @param name        the name
   * @param id          the id
   * @param payRate     the pay rate
   * @param payInterval the pay interval
   * @param isManager   the is manager
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Employee(String name, String id, double payRate, int payInterval, boolean isManager)
                      throws IllegalArgumentException {

    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Invalid employee name!");
    }
    if (id == null || id.length() == 0) {
      throw new IllegalArgumentException("Invalid employee ID!");
    }
    if (payRate < 0) {
      throw new IllegalArgumentException("Negative pay rate! ");
    }
    if (payInterval < 1) {
      throw new IllegalArgumentException("Pay interval can't be less than 1!");
    }

    this.name = name;
    this.id = id;
    this.isManager = isManager;
    this.paycheck = new SalariedPaycheck(payRate, payInterval);
  }

  /**
   * Instantiates a new Employee.
   *
   * @param name        the name
   * @param id          the id
   * @param payRate     the pay rate
   * @param hoursWorked the hours worked
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Employee(String name, String id, double payRate, double hoursWorked)
                    throws IllegalArgumentException {

    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Invalid employee name!");
    }
    if (id == null || id.length() == 0) {
      throw new IllegalArgumentException("Invalid employee ID!");
    }
    if (payRate < 0) {
      throw new IllegalArgumentException("Negative pay rate! ");
    }
    if (hoursWorked < 0) {
      throw new IllegalArgumentException("Negative worked hours!");
    }
    this.name = name;
    this.id = id;
    this.isManager = false;
    this.paycheck = new HourlyPaycheck(payRate, hoursWorked);
  }

  /**
   * Checks if an employee is manager.
   *
   * @return the boolean
   */
  public boolean isManager() {
    return this.isManager;
  }

  /**
   * Get paycheck for an employee.
   *
   * @return the paycheck
   */
  public IPaycheck getPaycheck() {
    return this.paycheck;
  }

  @Override
  public String toString() {
    String firstLine = String.format("Name: %s", this.name);
    String secondLine = String.format("ID: %s", this.id);
    String thirdLine = this.getPaycheck().toString();
    return (firstLine + "\n" + secondLine + "\n" + thirdLine);
  }
}
