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

	public double calcHoursProfit() {
		double profit = 0;

		switch (preference.getPreferenceType()) {
		case EARLY_START, LATE_START:
			int currentHourChange = this.preference.getHourChange();
			profit = (1.2 * currentHourChange) + (1 * (8 - currentHourChange));
			break;
		case HOME:
			profit = 1.1 * 8;
			break;
		case REGULAR_START:
			profit = 8;
			break;
		}
		return profit;
	}

	public double calcMoueyProfit() {
		double currentHourProfit = this.role.getProfitPerHour();
		return this.calcHoursProfit() * currentHourProfit;
	}

	public double calcHoursProfit(Preference p) {
		double profit = 0;
		if (this.preference.getStartHour() == p.getStartHour()) {
			if (this.preference.equals(p))
				return this.calcHoursProfit();
			else

				profit = 8;

		} else {

		}

		return profit;
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
