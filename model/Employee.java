package application.model;

public class Employee extends Person implements syncAble, choosePreference {
	protected int employeeId;
	protected static int idSerialCounter = 1000;
	protected Preference preference;
	protected Role role;
	private boolean sync;

	public Employee(String name, int yearOfBirth, Preference preference, Role role) throws Exception {
		super(name, yearOfBirth);
		this.employeeId = idSerialCounter++;

	}

	@Override
	public boolean isSynced() {
		return this.sync;
	}

	@Override
	public void choosePreference(PreferenceType t, int change) {
		this.preference = new Preference(t, change);

	}

	public Department getDepartment() {
		return this.role.getDepartment();

	}

	private int getEmployeeId() {
		return this.employeeId;
	}

	public Role getRole() {
		return this.role;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Employee))
			return false;
		Employee temp = (Employee) obj;
		if (temp.getEmployeeId() == this.employeeId)
			return true;
		else
			return false;
	}

}
