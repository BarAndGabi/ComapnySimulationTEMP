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
		Department logistic = this.addDepartment("logistic", false, PreferenceType.REGULAR_START, 0);
		Department cars = this.addDepartment("cars", false, PreferenceType.EARLY_START, 6);
		Department mangment = this.addDepartment("mangment", true, PreferenceType.REGULAR_START, 3);
		Department wizards = this.addDepartment("wizards", false, PreferenceType.LATE_START, 2);
		Role cleaner = this.addRole(35.5, "cleaner", true, logistic, p2, true);
		Role carSalesMan = this.addRole(34, "car sales man", true, cars, p3, true);
		Role fileOrganizer = this.addRole(25, "file organizer", true, mangment, p2, false);
		Role harryPotter = this.addRole(450.3, "harryPotter", false, wizards, p4, true);
		EmployeeGlobaly yossi = new EmployeeGlobaly("yossi", 2002, p3, 7500, fileOrganizer);
		EmployeeGlobaly bar = new EmployeeGlobaly("bar", 1996, p1, 11000, cleaner);
		EmployeeGlobalyPlus itay = new EmployeeGlobalyPlus("itay", 2000, p1, harryPotter, 23000);
		EmployeeGlobalyPlus ofir = new EmployeeGlobalyPlus("ofir", 1983, p4, fileOrganizer, 16000);
		EmployeeHourly mor = new EmployeeHourly("mor", 2002, p2, 55, carSalesMan);
		EmployeeHourly yotam = new EmployeeHourly("yotam", 2002, p2, 31, harryPotter);

	}

	@Override
	public void addEmployee(Employee a) {
		int index = this.findDepartment(a.getDepartment());
		this.departments.get(index).addEmployee(a);
	}

	private int findDepartment(Department d) {
		return this.departments.indexOf(d);

		
	}


	@Override
	public Department addDepartment(String name, boolean sync, PreferenceType p, int hourChange) throws Exception {
		Department d = new Department(name, sync, p, hourChange);
		for (int i = 0; i < this.departments.size(); i++) {
			if (this.departments.get(i).equals(d))
				throw new alreadyExistException();
		}
		this.departments.add(d);
		return d;
	}

	@Override
	public Role addRole(double ProfitPerHour, String jobTitle, boolean sync, Department d, Preference preference,
			boolean workFromHome) throws Exception {
		Role r = new Role(ProfitPerHour, jobTitle, sync, d, preference, workFromHome);
		int index = this.findDepartment(d);
		this.departments.get(index).addRole(r);
		return r;

	}

	@Override
	public void runSimulation() {
		// TODO Auto-generated method stub

	}
}
