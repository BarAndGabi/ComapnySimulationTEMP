package application.model;

public class Employee extends Person implements syncAble,choosePreference {
	private int employeeId;
	private static int idSerialCounter = 1000;
	private Preference preference;

	public Employee(String name, int yearOfBirth, Preference preference) throws Exception {
		super(name, yearOfBirth);
		this.employeeId = idSerialCounter++;

	}

	@Override
	public void syncObjectPrefrence(Preference p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void choosePreference() {
		// TODO Auto-generated method stub
		
	}

}
