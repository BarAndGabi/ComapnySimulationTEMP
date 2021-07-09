package application.model;

import java.util.ArrayList;

public class Department implements syncAble, choosePreference {
	private ArrayList<Role> roles;
	private boolean sync;
	private String name;
	private Preference preference;

	public Department(String name, boolean sync, Preference pType, int hourChange) {
		this.sync = sync;
	}

	@Override
	public void choosePreference() {
		// TODO Auto-generated method stub

	}

	public void addEmployee(Employee a, Role r) {
		int index = this.findRole(r);
		this.roles.get(index).addEmployee(a);

	}

	private int findRole(Role r) {
		return this.roles.indexOf(r);
	}

	public void addRole(Role r) throws Exception {
		int index = findRole(r);
		if (index == -1)
			this.roles.add(r);
		else
			throw new alreadyExistException();
	}

}
