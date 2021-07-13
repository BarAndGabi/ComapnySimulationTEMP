package application.model;

import java.util.ArrayList;

public class Department implements syncAble, choosePreference {
	private ArrayList<Role> roles;
	private ArrayList<Employee> employees;
	private boolean sync;
	private String name;
	private Preference preference;

	public Department(String name, boolean sync, PreferenceType p, int hourChange) {
		this.sync = sync;
		this.roles = new ArrayList<Role>();
		this.employees = new ArrayList<Employee>();
		this.name = name;
		this.preference = new Preference(p, hourChange);
	}

	@Override
	public void choosePreference(PreferenceType t, int change) {
		this.preference = new Preference(t, change);
	}

	public void addEmployee(Employee a) {
		int index = this.findRole(a.getRole());
		if (this.roles.get(index).addEmployee(a))
			this.employees.add(a);

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

	@Override
	public boolean isSynced() {
		return this.sync;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Department))
			return false;
		Department temp = (Department) obj;
		if (temp.getName() == this.name)
			return true;
		else
			return false;
	}

	private String getName() {
		return this.name;
	}

}
