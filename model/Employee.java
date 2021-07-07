package application.model;

public class Employee extends Person {
	private int employeeId;
	private static int idSerialCounter = 1000;
	private Preference preference;

	public Employee(String name, int yearOfBirth, Preference preference) throws Exception {
		super(name, yearOfBirth);
		this.employeeId = idSerialCounter++;

	}

}
