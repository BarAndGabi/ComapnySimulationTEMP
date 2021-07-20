package application.view;

import java.util.Vector;

import application.controller.ElectionsSystemController;

public interface AbstractView {

	void registerListener(ElectionsSystemController electionsSystemController);

	void addElectionsToUI(int year, int month, int i);

	void addBboxToUI(String adress, String type);

	void addCitizenToUI(String name, String id, String type);

	void addPartyToUI(String name);

	void addCandidateToUI(String name, String id, String partyBelong);

	void loadEarlyElections(Vector<String> datesStrings);

	void loadCurrentParties(Vector<String> partyStringNames);

	void addElectionsToUI(int year, int month);



}
