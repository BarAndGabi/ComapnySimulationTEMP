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

	/*
	 * public double calcHoursProfit(Preference p) { double profit = 0; int
	 * wantedEnd, wantedStart, end, start;
	 * 
	 * if (this.preference.getStartHour() == -1) if (p.getStartHour() == -1) profit
	 * = 1.1 * 8; else profit = 8; else { start = p.getStartHour(); end = start + 9;
	 * wantedStart = this.preference.getStartHour(); wantedEnd = wantedStart + 9; if
	 * ((wantedStart == start) || (p.getPreferenceType() ==
	 * PreferenceType.REGULAR_START)) profit = this.calcHoursProfit(); else if
	 * (start < wantedStart) if(wantedStart<8) profit
	 * =((wantedStart-start)*0.8)+((8-wantedStart)*1.2)+(end-8); else
	 * 
	 * 
	 * } return profit; }
	 */

	public double calcHoursProfit(Preference p) {
		double profit = 0;
		if (p.getPreferenceType() == PreferenceType.HOME) {
			if (this.preference.getPreferenceType() == PreferenceType.HOME)
				profit = 8 * 1.1;
			else
				profit = 8 * 1;
			return profit;
		}
		int employeeEnd, employeeStart, end, start;
		start = p.getStartHour();
		end = start + 9;
		employeeStart = this.preference.getStartHour();
		employeeEnd = employeeStart + 9;
		int randomLunchBreak = (int) (Math.random() * (end - start)) + start;
		for (int currentHour = start; currentHour < end; currentHour++) {
			if (currentHour != randomLunchBreak) {
				if (currentHour < 8) {
					if (employeeStart <= currentHour)
						profit += 1.2;
					else
						profit += 0.8;

				} else if (currentHour >= 8 && currentHour < 17) {
					profit++;

				} else if (currentHour > 17) {
					if (employeeEnd <= currentHour)
						profit += 0.8;
					else
						profit += 1.2;
				}
			}
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
