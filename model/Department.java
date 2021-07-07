package application.model;

import java.util.ArrayList;
import java.util.Set;

public class Department implements syncAble{
	private ArrayList<Set<Employee>> employeesByRoles;
	private ArrayList<Role> roles;
	private boolean sync;
	@Override
	public void changePrefrence(Preference p) {
		// TODO Auto-generated method stub
		
	}
}
