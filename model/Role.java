package application.model;

import java.util.ArrayList;

public class Role implements syncAble, choosePreference {

	private double profitPerHour;
	private String jobTitle;
	private ArrayList<Employee> EmployeesWithCurrentRole;
	private boolean sync;
	private Department department;
	private Preference preference;
	private boolean workFromHome;

	public Role(double ProfitPerHour, String jobTitle, boolean sync, Department department, Preference preference,
			boolean workFromHome) {
		this.department = department;
		this.jobTitle = jobTitle;
		this.profitPerHour = ProfitPerHour;
		this.sync = sync;
		this.preference = preference;
		this.workFromHome = workFromHome;
	}

	public boolean addEmployee(Employee a) {
		if (!(this.EmployeesWithCurrentRole.contains(a))) {
			this.EmployeesWithCurrentRole.add(a);
			return true;
		}
		return false;
	}

	@Override
	public void choosePreference(PreferenceType t, int change) {
		this.preference = new Preference(t, change);

	}

	@Override
	public boolean isSynced() {
		return this.sync;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Role))
			return false;
		Role temp = (Role) obj;
		if (temp.jobTitle() == this.jobTitle)
			return true;
		else
			return false;
	}

	private String jobTitle() {
		return this.jobTitle;
	}

	public Department getDepartment() {
		return this.department;
	}

	public double getProfitPerHour() {
		return this.profitPerHour;
	}

}
