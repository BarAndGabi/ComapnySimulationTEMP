package application.model;

public class Employee extends Person implements syncAble, choosePreference {
	protected int employeeId;
	protected static int idSerialCounter = 1000;
	protected Preference preference;
	protected Role role;

	public Employee(String name, int yearOfBirth, Preference preference, Role role) throws Exception {
		super(name, yearOfBirth);
		this.employeeId = idSerialCounter++;

	}

	@Override
	public void choosePreference() {
		// TODO Auto-generated method stub

	}

}
