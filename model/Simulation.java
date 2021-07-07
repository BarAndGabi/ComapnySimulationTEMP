package application.model;

public class Simulation {
	private String companyDataAtSimulation;
	private int daysToSimulate;
	private String results;

	public Simulation(String companyDataAtSimulation, int days) {
		this.companyDataAtSimulation = companyDataAtSimulation;
		this.daysToSimulate = days;
	}
}
