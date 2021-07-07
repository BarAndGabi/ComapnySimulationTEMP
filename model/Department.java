package application.model;

import java.util.ArrayList;

public class Department implements syncAble, choosePreference {
	private ArrayList<ArrayList<Employee>> employeesByRoles;
	private ArrayList<Role> roles;
	private boolean sync;

	public Department(boolean sync) {
		setRoles(this.roles);
		setEmployeesByRoles(this.employeesByRoles);

	}

	private void setEmployeesByRoles(ArrayList<ArrayList<Employee>> employeesByRoles2) {
		// TODO Auto-generated method stub
		
	}

	private void setRoles(ArrayList<Role> roles) {
		// TODO Auto-generated method stub

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
