package application.model;

import java.util.ArrayList;

public class Department implements syncAble, choosePreference {
	private ArrayList<ArrayList<Employee>> employeesByRoles;
	private ArrayList<Role> roles;
	private boolean sync;

	@Override
	public void syncObjectPrefrence(Preference p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void choosePreference() {
		// TODO Auto-generated method stub

	}
}
