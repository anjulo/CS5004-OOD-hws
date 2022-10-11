/**
 * The Employee class.
 *
 * @author Bereket Yisehak
 */
public class Employee {

  private String name;
  private String id;
  private double totalHours;
  private double payRate;

  /**
   * Instantiates a new Employee.
   *
   * @param name    name of the employee
   * @param id      id of the employee
   * @param payRate the hourly pay rate of the employee
   */
  public Employee(String name, String id, double payRate) {
    this.name = name;
    this.id = id;
    this.payRate = payRate;
    this.totalHours = 0;
  }

  /**
   * Add hours worked.
   *
   * @param todayHours  the hours worked to be added
   */
  public void addHoursWorked(double todayHours) {

    this.totalHours += todayHours;
    if (this.totalHours < 0) {
      this.totalHours = 0;
    }
  }

  /**
   * Reset hours worked.
   */
  public void resetHoursWorked() {
    this.totalHours = 0;
  }

  /**
   * Get hours worked.
   *
   * @return the total hours worked by an employee
   */
  public double getHoursWorked() {
    return this.totalHours;
  }

  /**
   * Get weekly paycheck.
   *
   * @return the paycheck class
   */
  public Paycheck getWeeklyCheck() {
    Paycheck weeklyCheck = new Paycheck(this.payRate, this.totalHours);
    return weeklyCheck;
  }

  /**
   * Outputs a formatted String representing an employee information.
   *
   * @return String A string representing the employee class
   */
  public String toString() {
    String firstLine = String.format("Name: %s", this.name);
    String secondLine = String.format("ID: %s", this.id);
    String thirdLine = this.getWeeklyCheck().toString();
    String wholeString = firstLine + "\n" + secondLine + "\n" + thirdLine;
    return wholeString;
  }

}
