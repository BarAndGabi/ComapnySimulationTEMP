package application.model;

public class Simulation {
	private String companyDataAtSimulation;
	private int daysToSimulate;
	private String results;
	private int simulationNum;
	private static int Counter = 1;

	public Simulation(String companyDataAtSimulation, int days) {
		this.companyDataAtSimulation = companyDataAtSimulation;
		this.daysToSimulate = days;
		this.simulationNum = Counter++;
	}
}
