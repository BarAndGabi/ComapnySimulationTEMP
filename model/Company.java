package application.model;

import java.util.ArrayList;

public class Company implements CompanyInterface {
	private ArrayList<Department> departments;
	private ArrayList<Simulation> SimulationsArchive;
	private ArrayList<Role> roles;

	public Company() {
		this.SimulationsArchive = new ArrayList<Simulation>();
		this.departments = new ArrayList<Department>();
		this.roles = new ArrayList<Role>();
		this.addHardCoded();
	}

	private void addHardCoded() {
		// TODO Auto-generated method stub

	}
}
