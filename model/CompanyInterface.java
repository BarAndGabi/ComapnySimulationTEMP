package application.model;

public interface CompanyInterface {
	void addEmployee(Employee a);

	Role addRole(double ProfitPerHour, String jobTitle, boolean sync, Department d, Preference preference,
			boolean workFromHome) throws Exception;

	void runSimulation();

	Department addDepartment(String name, boolean sync, PreferenceType p, int hourChange) throws Exception;

}