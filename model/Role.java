package application.model;

import java.util.ArrayList;

public class Role implements syncAble, choosePreference {

	private double ProfitPerHour;
	private String jobTitle;
	private ArrayList<Employee> EmployeesWithCurrentRole;
	private boolean sync;
	private Department department;
	private Preference preference;

	public Role(double ProfitPerHour, String jobTitle, boolean sync, Department department, Preference preference) {
		this.department = department;
		this.jobTitle = jobTitle;
		this.ProfitPerHour = ProfitPerHour;
		this.sync = sync;
		this.preference = preference;
	}



	public void addEmployee(Employee a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void choosePreference() {
		// TODO Auto-generated method stub

	}

}
