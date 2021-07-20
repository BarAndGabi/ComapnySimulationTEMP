package application.listeners;

import java.io.FileNotFoundException;
import java.io.IOException;

import application.controller.TooYoungToVoteException;
import application.model.BallotType;
import application.model.Citizen;
import application.model.CitizenSet;
import application.model.PoliticalOpinion;

public interface UIEventListener {

	void loadFileEvent(boolean b) throws Exception;

	void setElectionIndex(int indexSelection);

	void CreateElectionEvent(String Year, String Month) throws Exception;

	void createBboxEvent(String text, BallotType regular) throws Exception;

	void createCitizenUIEvent(String text, String text2, String text3) throws Exception;

	void createSickCitizenUIEvent(String text, String text2, String text3, String text4) throws Exception;

	void createPartyEvent(String text, PoliticalOpinion center) throws Exception;

	String getBboxTostring();

	void saveFileEventUR() throws FileNotFoundException, IOException;

	void createCandidateUIEvent(String text, String text2, String text3, String value)
			throws TooYoungToVoteException, Exception;

	void createSickCandidateUIevent(String text, String text2, String text3, String text4, String value)
			throws Exception;

	String getPartyTostring();

	String getCitizensTostring();

	String getResultTostring();

	CitizenSet<Citizen> getCitizensToVote();

	void returnElectionsVotes(CitizenSet<Citizen> citizensToVote);

	void resetVoteCount();

}
