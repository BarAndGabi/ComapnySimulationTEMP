package application.model;

public class EmployeeGlobaly extends Employee {
	private final int hourPerMonth = 160;
	private int salaryPerMonth;

	public EmployeeGlobaly(String name, int yearOfBirth, Preference preference, int salaryPerMonth) throws Exception {
		super(name, yearOfBirth, preference);
		this.salaryPerMonth = salaryPerMonth;

	}

}
