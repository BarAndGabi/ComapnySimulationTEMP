package application.model;

public interface CompanyInterface {
	void addEmployee(Employee a, Role r, Department d);

	Department addDepartment(String name, boolean sync, Preference pType, int hourChange) throws Exception;

	Role addRole(double ProfitPerHour, String jobTitle, boolean sync, Department d, Preference preference)
			throws Exception;
}