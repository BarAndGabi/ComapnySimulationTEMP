package application.model;

public class EmployeeHourly extends Employee {
	private int hourPerMonth;
	private int salaryPerhour;

	public EmployeeHourly(String name, int yearOfBirth, Preference preference, int salaryPerHour, Role role)
			throws Exception {
		super(name, yearOfBirth, preference, role);
		this.salaryPerhour = salaryPerHour;

	}

}
