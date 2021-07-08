package application.model;

public interface CompanyInterface {
	void addEmployee(Employee a);

	void addDepartment(Department d);

	void addRole(Role r,Department d);
}
