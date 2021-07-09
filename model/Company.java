package application.model;

import java.util.ArrayList;

public class Company implements CompanyInterface {
	private ArrayList<Department> departments;
	private ArrayList<Simulation> SimulationsArchive;

	public Company() throws Exception {
		this.SimulationsArchive = new ArrayList<Simulation>();
		this.departments = new ArrayList<Department>();
		this.addHardCoded();
	}

	private void addHardCoded() throws Exception {
		Preference p1 = new Preference(PreferenceType.REGULAR_START, 0);
		Preference p2 = new Preference(PreferenceType.LATE_START, 2);
		Preference p3 = new Preference(PreferenceType.EARLY_START, 8);
		Preference p4 = new Preference(PreferenceType.HOME, 0);
		Department logistic = this.addDepartment("logistic", false, p1, 0);
		Department cars = this.addDepartment("cars", false, p2, 0);
		Department mangment = this.addDepartment("mangment", true, p3, 0);
		Department wizards = this.addDepartment("wizards", false, p4, 0);
		Role cleaner = this.addRole(35.5, "cleaner", true, logistic, p3);
		Role carSalesMan = this.addRole(34, "car sales man", true, cars, p1);
		Role fileOrganizer = this.addRole(25, "file organizer", true, mangment, p2);
		Role harryPotter = this.addRole(450.3, "harryPotter", false, wizards, p4);

	}

	@Override
	public void addEmployee(Employee a, Role r, Department d) {
		int index = this.findDepartment(d);
		this.departments.get(index).addEmployee(a, r);
	}

	private int findDepartment(Department d) {
		return this.departments.indexOf(d);

	}

	@Override
	public Department addDepartment(String name, boolean sync, Preference pType, int hourChange) throws Exception {
		Department d = new Department(name, sync, pType, hourChange);
		for (int i = 0; i < this.departments.size(); i++) {
			if (this.departments.get(i).equals(d))
				throw new alreadyExistException();
		}
		this.departments.add(d);
		return d;
	}

	@Override
	public Role addRole(double ProfitPerHour, String jobTitle, boolean sync, Department d, Preference preference)
			throws Exception {
		Role r = new Role(ProfitPerHour, jobTitle, sync, d, preference);
		int index = this.findDepartment(d);
		this.departments.get(index).addRole(r);
		return r;

	}

}
