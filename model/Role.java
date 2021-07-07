package application.model;

import java.util.ArrayList;

public class Role implements syncAble{

	private double ProfitPerHour;
	private String jobTitle;
	private ArrayList<Employee> EmployeesWithCurrentRole;
	@Override
	public void syncObjectPrefrence(Preference p) {
		// TODO Auto-generated method stub
		
	}

}
