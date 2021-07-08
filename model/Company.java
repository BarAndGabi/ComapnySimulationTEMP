package application.model;

import java.util.ArrayList;

public class Company implements CompanyInterface {
	private ArrayList<Department> departments;
	private ArrayList<Simulation> SimulationsArchive;

	public Company() {
		this.SimulationsArchive = new ArrayList<Simulation>();
		this.departments = new ArrayList<Department>();
		this.addHardCoded();
	}

	private void addHardCoded() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEmployee(Employee a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDepartment(Department d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRole(Role r) {
		// TODO Auto-generated method stub
		
	}
}
