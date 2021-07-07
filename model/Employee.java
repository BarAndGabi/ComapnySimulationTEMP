package application.model;

public class Employee extends Person {
	private int employeeId;
	private static int idSerialCounter = 1000;

	public Employee(String name, int yearOfBirth) throws Exception {
		super(name, yearOfBirth);
	}

}
