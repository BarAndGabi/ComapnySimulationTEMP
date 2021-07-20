package application.view;

import java.util.Vector;
import application.controller.ElectionsSystemController;
import application.listeners.UIEventListener;
import application.model.BallotType;
import application.model.Citizen;
import application.model.CitizenSet;
import application.model.PoliticalOpinion;
import application.model.Sickable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class View implements AbstractView {
	private boolean yesLoad = false;
	private boolean boolHasMask;
	int indexSelection = 0;
	private int citizensCount = 0;
	private String partyChosen = null;
	private Stage voteStage = new Stage();
	private Vector<UIEventListener> listeners = new Vector<UIEventListener>();
	private ComboBox<String> cmbElectionArchive = new ComboBox<String>();
	private ComboBox<String> cmbParties = new ComboBox<String>();
	private ComboBox<String> cmbParties1 = new ComboBox<String>();

	private ComboBox<String> cmbPartiesVote = new ComboBox<String>();
	private GridPane gpLoadFile = new GridPane();
	private GridPane gpMask = new GridPane();
	private GridPane gpLastChance = new GridPane();
	private GridPane gpSelectElection = new GridPane();
	private GridPane gpNewElection = new GridPane();
	private GridPane gpMenu = new GridPane();
	private GridPane gpCreateBbox = new GridPane();
	private GridPane gpShoWBB = new GridPane();
	private GridPane gpShoWP = new GridPane();
	private GridPane gpShoWCIT = new GridPane();
	private GridPane gpShoWResult = new GridPane();
	private GridPane gpCreateParty = new GridPane();
	private GridPane gpCreateSickCitizen = new GridPane();
	private GridPane gpCreateCitizen = new GridPane();
	private GridPane gpCreateCandidate = new GridPane();
	private GridPane gpCreateSickCandidate = new GridPane();
	private GridPane gpIsCandSick = new GridPane();
	private GridPane gpIsSick = new GridPane();
	private GridPane gpVote = new GridPane();
	private Scene lastChance = new Scene(gpLastChance, 330, 100);
	private Scene ShowBB = new Scene(gpShoWBB, 500, 700);
	private Scene ShowP = new Scene(gpShoWP, 500, 700);
	private Scene ShowCIT = new Scene(gpShoWCIT, 500, 700);
	private Scene ShowResult = new Scene(gpShoWResult, 500, 700);
	private Scene isCandSick = new Scene(gpIsCandSick, 150, 100);
	private Scene createCandidate = new Scene(gpCreateCandidate, 530, 350);
	private Scene createSickCandidate = new Scene(gpCreateSickCandidate, 530, 370);
	private Scene isSick = new Scene(gpIsSick, 150, 100);
	private Scene mask = new Scene(gpMask, 215, 150);
	private Scene loadFile = new Scene(gpLoadFile, 400, 120);
	private Scene ChooseElection = new Scene(gpSelectElection, 400, 120);
	private Scene vote = new Scene(gpVote, 450, 120);
	private Scene menu = new Scene(gpMenu, 420, 650);
	private Scene newElection = new Scene(gpNewElection, 400, 120);
	private Scene createBbox = new Scene(gpCreateBbox, 500, 250);
	private Scene createParty = new Scene(gpCreateParty, 500, 250);
	private Scene createCitizen = new Scene(gpCreateCitizen, 450, 280);
	private Scene createSickCitizen = new Scene(gpCreateSickCitizen, 450, 300);
	private TextField tfNewYear = new TextField("2020");
	private TextField tfNewMonth = new TextField("2");
	private TextField tfBboxAdress = new TextField("Tel aviv");
	private TextField tfPartyName = new TextField("meretz");
	private TextField tfCitizenName = new TextField("israel israeli");
	private TextField tfCitizenID = new TextField("123456789");
	private TextField tfCitizenYOB = new TextField("1995");
	private TextField tfCitizenName1 = new TextField("israel israeli");
	private TextField tfCitizenID1 = new TextField("123456789");
	private TextField tfCitizenYOB1 = new TextField("1995");
	private TextField tfSickDays = new TextField("3");
	private TextField tfCandName = new TextField("israel israeli");
	private TextField tfCandID = new TextField("123456789");
	private TextField tfCandYOB = new TextField("1995");
	private TextField tfCandName1 = new TextField("israel israeli");
	private TextField tfCandID1 = new TextField("123456789");
	private TextField tfCandYOB1 = new TextField("1995");
	private TextField tfCandSickDays = new TextField("3");
	private ToggleGroup tgBboxCreate = new ToggleGroup();
	private RadioButton rdoBboxType1 = new RadioButton("Regular");
	private RadioButton rdoBboxType2 = new RadioButton("For soliders");
	private RadioButton rdoBboxType3 = new RadioButton("For sick");
	private RadioButton rdoBboxType4 = new RadioButton("For sick soliders");
	private ToggleGroup tgPartyCreate = new ToggleGroup();
	private RadioButton rdoParty1 = new RadioButton("center");
	private RadioButton rdoParty2 = new RadioButton("right");
	private RadioButton rdoParty3 = new RadioButton("left");
	private Label lblCitizenName = new Label("enter your name");
	private Label lblCitizenID = new Label("enter your id");
	private Label lblCitizenYOB = new Label("enter year of birth");
	private Label lblSickDays = new Label("enter days of sickness");
	private Label lblCreateCIT = new Label("Citizen create");
	private Label lblCreateCAND = new Label("Candidate create");
	private Label lblCitizenName1 = new Label("enter your name");
	private Label lblCitizenID1 = new Label("enter your id");
	private Label lblCitizenYOB1 = new Label("enter year of birth");
	private Label lblSickDays1 = new Label("enter days of sickness");
	private Label lblCreateCIT1 = new Label("Sick citizen create");
	private Label lblCreateCAND1 = new Label("Sick candidate create");
	private Label lblCandName = new Label("enter your name");
	private Label lblCandID = new Label("enter your id");
	private Label lblCandYOB = new Label("enter year of birth");
	private Label lblCandName1 = new Label("enter your name");
	private Label lblCandID1 = new Label("enter your id");
	private Label lblCandYOB1 = new Label("enter year of birth");
	private Label lblMask = new Label("do you have mask ?");

	private Label lblVote = new Label("Choose you vote : ");
	private TextArea TAShowBB = new TextArea();
	private TextArea TAShowCIT = new TextArea();
	private TextArea TAShowP = new TextArea();
	private TextArea TAShowResult = new TextArea();
	private Image logo = new Image(getClass().getResourceAsStream("logoElection.png"));
	private Button btnExitAndSave = new Button("EXIT&SAVE");
	private CitizenSet<Citizen> citizensToVote = null;

	public View(final Stage theStage) {
		theStage.setTitle("Elections Systems");
		theStage.getIcons().add(logo);
		voteStage.getIcons().add(logo);
		cmbElectionArchive.setPromptText("choose election");
		cmbPartiesVote.getItems().add("empty vote");
		this.setupGridPane(gpLoadFile, 8);
		this.setupGridPane(gpSelectElection, 8);
		this.setupGridPane(gpNewElection, 8);
		this.setupGridPane(gpMenu, 8);
		this.setupGridPane(gpVote, 8);
		this.setupGridPane(gpCreateBbox, 8);
		this.setupGridPane(gpCreateParty, 8);
		this.setupGridPane(gpIsSick, 8);
		this.setupGridPane(gpCreateCitizen, 8);
		this.setupGridPane(gpCreateSickCitizen, 8);
		this.setupGridPane(gpIsCandSick, 8);
		this.setupGridPane(gpCreateCandidate, 8);
		this.setupGridPane(gpCreateSickCandidate, 8);
		this.setupGridPane(gpShoWBB, 8);
		this.setupGridPane(gpShoWP, 8);
		this.setupGridPane(gpShoWResult, 8);
		this.setupGridPane(gpShoWCIT, 8);
		this.setupGridPane(gpLastChance, 8);
		this.setupGridPane(gpMask, 8);
		gpShoWBB.setAlignment(Pos.CENTER_RIGHT);
		gpMenu.setAlignment(Pos.TOP_LEFT);
		gpVote.setAlignment(Pos.TOP_LEFT);
		createCitizen.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		ChooseElection.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		isSick.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		loadFile.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		menu.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		newElection.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		createBbox.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		createSickCitizen.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		createParty.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		ShowBB.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		isCandSick.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		createCandidate.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		createSickCandidate.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		ShowResult.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		ShowP.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		ShowCIT.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		lastChance.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		vote.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		mask.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		Font f = new Font("Comic Sans MS", 18);
		Label lbllastChance = new Label("are you sure??? no backsies! ");
		Label lblLoad = new Label("WOULD YOU LIKE TO LOAD PREVIUSE FILE ? ");
		Label lblChooseElection = new Label("please choose the election you would \nlike to upload:");
		Label lblNewElection = new Label("please enter the date of the election:");
		Label lblMenu = new Label("choose function :");
		lblMenu.setFont(f);
		Label lblAdressBB = new Label("enter your adress ");
		Label lblCreateBB = new Label("ballot box create");
		Label lblTypeBB = new Label("choose ballot box type");
		Label lblPartyName = new Label("enter party name ");
		Label lblCreateP = new Label("Party create");
		Label lblTypeP = new Label("choose political opinion");
		Label lblSick = new Label("Are you sick ?");
		Label lblCandSick = new Label("Are you sick ?");
		Label lblPartyChoose = new Label("choose your party");
		Label lblPartyChoose1 = new Label("choose your party");
		Button btnSubmitCH = new Button("SUBMIT");
		Button btnCancelBackToMENU = new Button("CANCEL");
		Button btnCancelBackToMENU1 = new Button("CANCEL");
		Button btnCancelBackToMENU2 = new Button("CANCEL");
		Button btnCancelBackToMENU3 = new Button("CANCEL");
		Button btnCancelBackToMENU4 = new Button("CANCEL");
		Button btnCancelBackToMENU5 = new Button("CANCEL");
		Button btnCancelBackToMENU6 = new Button("CANCEL");
		Button btnCancelBackToMENU7 = new Button("CANCEL");
		Button btnCancelBackToMENU8 = new Button("CANCEL");
		Button btnCancelBackToMENU9 = new Button("CANCEL");
		Button btnNewElectionCH = new Button("NEW ELECTION");
		Button btnSave = new Button("SAVE");
		btnExitAndSave.setStyle(" -fx-background-color: #EA4336;\n" + "    -fx-background-radius: 30;\n"
				+ "    -fx-background-insets: 0;\n" + "    -fx-text-fill: white;\n");
		Button btnYesL = new Button("YES");
		Button btnNoL = new Button("NO");
		Button btnLastChanceY = new Button("YES");
		Button btnLastChanceN = new Button("NO");
		Button btnYesSick = new Button("YES");
		Button btnNoSick = new Button("NO");
		Button btnYesMask = new Button("YES");
		Button btnNoMask = new Button("NO");
		Button btnYesCandSick = new Button("YES");
		Button btnNoCandSick = new Button("NO");
		Button btnNextNew = new Button("NEXT");
		Button btnCancelNew = new Button("CANCEL");
		Button btnCreateBbox = new Button("create ballot box");
		Button btnCreateParty = new Button("create Party");
		Button btnCreateCIT = new Button("create Citizen");
		Button btnCreateCAND = new Button("create Candidate");
		Button btnSubmitBB = new Button("SUBMIT");
		Button btnSubmitP = new Button("SUBMIT");
		Button btnShowBB = new Button("Show ballot boxs");
		Button btnShowP = new Button("Show parties");
		Button btnShowCIT = new Button("Show citizens");
		Button btnShowResult = new Button("Show elections results");
		Button btnRunElection = new Button("Run elections");
		Button btnNewRound = new Button("create new election");
		Button btnSubmitCIT = new Button("SUBMIT");
		Button btnSubmitSickCIT = new Button("SUBMIT");
		Button btnSubmitCAND = new Button("SUBMIT");
		Button btnSubmitSickCAND = new Button("SUBMIT");
		Button btnNextVote = new Button("NEXT");
		menu.setCursor(Cursor.HAND);
		rdoParty1.setToggleGroup(tgPartyCreate);
		rdoParty3.setToggleGroup(tgPartyCreate);
		rdoParty2.setToggleGroup(tgPartyCreate);
		rdoBboxType1.setToggleGroup(tgBboxCreate);
		rdoBboxType2.setToggleGroup(tgBboxCreate);
		rdoBboxType3.setToggleGroup(tgBboxCreate);
		rdoBboxType4.setToggleGroup(tgBboxCreate);
		setStyleForTA(TAShowBB);
		setStyleForTA(TAShowResult);
		setStyleForTA(TAShowCIT);
		setStyleForTA(TAShowP);
		btnCreateBbox.setMaxWidth(Double.MAX_VALUE);
		btnCreateCIT.setMaxWidth(Double.MAX_VALUE);
		btnCreateParty.setMaxWidth(Double.MAX_VALUE);
		btnCreateCAND.setMaxWidth(Double.MAX_VALUE);
		btnShowBB.setMaxWidth(Double.MAX_VALUE);
		btnShowCIT.setMaxWidth(Double.MAX_VALUE);
		btnShowP.setMaxWidth(Double.MAX_VALUE);
		btnShowResult.setMaxWidth(Double.MAX_VALUE);
		btnShowResult.setMaxWidth(Double.MAX_VALUE);
		btnRunElection.setMaxWidth(Double.MAX_VALUE);
		btnNewRound.setMaxWidth(Double.MAX_VALUE);
		btnSave.setMaxWidth(Double.MAX_VALUE);
		btnYesL.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				yesLoad = true;
				for (UIEventListener l : listeners) {
					try {
						l.loadFileEvent(true);
						theStage.setScene(ChooseElection);

					} catch (Exception e) {
						exceptionAlert(e);

					}
				}
			}
		});
		btnExitAndSave.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				btnExitAndSave.setStyle(" -fx-background-color: #47535A;\n" + "    -fx-background-radius: 30;\n"
						+ "    -fx-background-insets: 0;\n" + "    -fx-text-fill: white;\n");

				for (UIEventListener l : listeners) {

					try {
						l.saveFileEventUR();
					} catch (Exception e) {
						// exceptionAlert(e);
						System.out.println(e.getMessage());

					}
					quitApp(theStage);

				}
			}
		});
		btnSave.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				for (UIEventListener l : listeners) {

					try {
						l.saveFileEventUR();
					} catch (Exception e) {
						// exceptionAlert(e);
						System.out.println(e.getMessage());

					}

				}
			}
		});
		btnCancelBackToMENU.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				theStage.setScene(menu);
			}
		});
		btnCancelBackToMENU1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				theStage.setScene(menu);
			}
		});
		btnCancelBackToMENU2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				theStage.setScene(menu);
			}
		});
		btnCancelBackToMENU3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				theStage.setScene(menu);
			}
		});
		btnCancelBackToMENU4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				theStage.setScene(menu);
			}
		});
		btnCancelBackToMENU5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				theStage.setScene(menu);
			}
		});
		btnCancelBackToMENU6.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				theStage.setScene(menu);
			}
		});
		btnCancelBackToMENU7.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				theStage.setScene(menu);
			}
		});
		btnCancelBackToMENU8.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {

				theStage.setScene(menu);
			}
		});
		btnCancelBackToMENU9.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {

				theStage.setScene(menu);
			}
		});

		btnNoL.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				theStage.setScene(newElection);

			}

		});
		btnSubmitCH.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					if (cmbElectionArchive.getItems().size() == 0)
						throw new NoItemException();
					String selection = (String) cmbElectionArchive.getValue();
					indexSelection = Character.getNumericValue(selection.charAt(0)) - 1;
					for (UIEventListener l : listeners) {
						l.setElectionIndex(indexSelection);
						theStage.setScene(menu);
					}
				} catch (Exception e) {
					exceptionAlert(e);
				}
			}
		});
		btnCancelNew.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (yesLoad)
					theStage.setScene(ChooseElection);
				else
					quitApp(theStage);
			}

		});
		btnNewElectionCH.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				theStage.setScene(newElection);
			}
		});
		btnNextNew.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				for (UIEventListener l : listeners) {
					try {
						l.CreateElectionEvent((tfNewYear.getText()), (tfNewMonth.getText()));
						theStage.setScene(menu);
						l.setElectionIndex(-1);
					} catch (Exception e) {
						exceptionAlert(e);
					}
				}
			}
		});
		btnNewRound.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				theStage.setScene(lastChance);
			}
		});
		btnSubmitBB.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				for (UIEventListener l : listeners) {
					try {
						if (rdoBboxType1.isSelected())
							l.createBboxEvent(tfBboxAdress.getText(), BallotType.REGULAR);
						else if (rdoBboxType2.isSelected())
							l.createBboxEvent(tfBboxAdress.getText(), BallotType.FOR_SOLIDERS);
						else if (rdoBboxType3.isSelected())
							l.createBboxEvent(tfBboxAdress.getText(), BallotType.FOR_SICK);
						else if (rdoBboxType4.isSelected())
							l.createBboxEvent(tfBboxAdress.getText(), BallotType.FOR_SICK_SOLIDERS);
						else
							throw new EmptyException();
						loadSucssesAlert();
						theStage.setScene(menu);
					} catch (Exception e) {
						exceptionAlert(e);
					}
				}
			}
		});
		btnSubmitP.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				for (UIEventListener l : listeners) {
					try {
						if (rdoParty1.isSelected())
							l.createPartyEvent(tfPartyName.getText(), PoliticalOpinion.CENTER);
						else if (rdoParty2.isSelected())
							l.createPartyEvent(tfPartyName.getText(), PoliticalOpinion.RIGHT);
						else if (rdoParty3.isSelected())
							l.createPartyEvent(tfPartyName.getText(), PoliticalOpinion.LEFT);
						else
							throw new EmptyException();
						loadSucssesAlert();
						theStage.setScene(menu);
					} catch (Exception e) {
						exceptionAlert(e);
					}
				}
			}
		});
		btnCreateBbox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				theStage.setScene(createBbox);
			}
		});
		btnCreateParty.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				theStage.setScene(createParty);
			}
		});
		btnCreateCIT.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				theStage.setScene(isSick);
			}
		});
		btnCreateCAND.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				theStage.setScene(isCandSick);
			}
		});
		btnNoSick.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				theStage.setScene(createCitizen);
			}
		});
		btnYesSick.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				theStage.setScene(createSickCitizen);
			}
		});
		btnNoCandSick.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				theStage.setScene(createCandidate);
			}
		});
		btnYesCandSick.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {

				theStage.setScene(createSickCandidate);
			}
		});
		btnSubmitCIT.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {

				try {
					for (UIEventListener l : listeners) {
						l.createCitizenUIEvent(tfCitizenName.getText(), tfCitizenID.getText(), tfCitizenYOB.getText());
					}
					loadSucssesAlert();
					theStage.setScene(menu);
				} catch (Exception e) {
					exceptionAlert(e);
				}

			}
		});
		btnSubmitSickCIT.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {

				try {
					for (UIEventListener l : listeners) {
						l.createSickCitizenUIEvent(tfCitizenName.getText(), tfCitizenID.getText(),
								tfCitizenYOB.getText(), tfSickDays.getText());
					}
					loadSucssesAlert();
					theStage.setScene(menu);
				} catch (Exception e) {
					exceptionAlert(e);
				}

			}
		});
		btnSubmitCAND.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {

				try {
					for (UIEventListener l : listeners) {
						l.createCandidateUIEvent(tfCandName.getText(), tfCandID.getText(), tfCandYOB.getText(),
								cmbParties1.getValue());
					}
					loadSucssesAlert();

					theStage.setScene(menu);
				} catch (Exception e) {
					exceptionAlert(e);
				}

			}
		});
		btnSubmitSickCAND.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {

				try {
					for (UIEventListener l : listeners) {
						l.createSickCandidateUIevent(tfCandName1.getText(), tfCandID1.getText(), tfCandYOB1.getText(),
								tfCandSickDays.getText(), cmbParties.getValue());
					}
					loadSucssesAlert();
					theStage.setScene(menu);
				} catch (Exception e) {
					exceptionAlert(e);
				}

			}
		});
		btnShowBB.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				TAShowBB.setText(getBboxTostring());
				theStage.setScene(ShowBB);
			}
		});
		btnShowP.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				TAShowP.setText(getPartyTostring());
				theStage.setScene(ShowP);
			}
		});
		btnShowCIT.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				TAShowCIT.setText(getCitizensTostring());
				theStage.setScene(ShowCIT);
			}
		});
		btnShowResult.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				TAShowResult.setText(getResultTostring());
				theStage.setScene(ShowResult);
			}
		});
		btnLastChanceN.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				theStage.setScene(menu);
			}
		});
		btnLastChanceY.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				theStage.setScene(ChooseElection);
			}
		});
		btnRunElection.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					for (UIEventListener l : listeners) {
						l.resetVoteCount();
						citizensToVote = l.getCitizensToVote();
						for (int i = 0; i < citizensToVote.getCurrentSize(); i++) {
							if (citizensToVote.get(i) instanceof Sickable) {
								voteStage.setTitle(citizensToVote.get(i).getName());
								voteStage.setScene(mask);
								voteStage.showAndWait();

								if (boolHasMask) {
									voteStage.setTitle(citizensToVote.get(i).getName());
									voteStage.setScene(vote);
									voteStage.showAndWait();
									citizensToVote.get(i).setPartyChosen(partyChosen);
								} else
									citizensToVote.get(i).setPartyChosen(null);
							} else {
								voteStage.setTitle(citizensToVote.get(i).getName());
								voteStage.setScene(vote);
								voteStage.showAndWait();
								citizensToVote.get(i).setPartyChosen(partyChosen);
							}
						}
						l.returnElectionsVotes(citizensToVote);
						voteSucssesAlert();
					}
				} catch (Exception e) {
					exceptionAlert(e);
				}
			}
		});
		btnNextVote.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				partyChosen = cmbPartiesVote.getValue();
				if (partyChosen.equals("empty vote"))
					partyChosen = null;

				voteStage.close();
			}
		});
		btnYesMask.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				boolHasMask = true;
				voteStage.close();

			}
		});
		btnNoMask.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				boolHasMask = false;
				voteStage.close();

			}
		});
		gpCreateCandidate.add(cmbParties1, 3, 12);

		gpNewElection.add(lblNewElection, 0, 0);
		gpNewElection.add(tfNewYear, 0, 1);
		gpNewElection.add(tfNewMonth, 2, 1);
		gpNewElection.add(btnNextNew, 0, 2);
		gpNewElection.add(btnCancelNew, 2, 2);
		gpSelectElection.add(lblChooseElection, 0, 0);
		gpSelectElection.add(cmbElectionArchive, 1, 0);
		gpSelectElection.add(btnSubmitCH, 1, 1);
		gpSelectElection.add(btnNewElectionCH, 0, 1);
		gpLoadFile.add(lblLoad, 0, 0);
		gpLoadFile.add(btnNoL, 3, 2);
		gpLoadFile.add(btnYesL, 2, 2);
		gpMenu.add(lblMenu, 15, 0);
		gpMenu.add(btnCreateBbox, 15, 3);
		gpMenu.add(btnCreateParty, 15, 9);
		gpMenu.add(btnCreateCIT, 15, 6);
		gpMenu.add(btnShowP, 15, 18);
		gpMenu.add(btnShowCIT, 15, 21);
		gpMenu.add(btnShowResult, 15, 27);
		gpMenu.add(btnShowBB, 15, 15);
		gpMenu.add(btnCreateCAND, 15, 12);
		gpMenu.add(btnRunElection, 15, 24);
		gpMenu.add(btnNewRound, 15, 30);
		gpMenu.add(btnExitAndSave, 20, 36);
		gpMenu.add(btnSave, 15, 33);
		gpCreateBbox.add(lblCreateBB, 2, 0);
		gpCreateBbox.add(lblAdressBB, 0, 3);
		gpCreateBbox.add(lblTypeBB, 0, 6);
		gpCreateBbox.add(tfBboxAdress, 2, 3);
		gpCreateBbox.add(rdoBboxType1, 0, 8);
		gpCreateBbox.add(rdoBboxType2, 0, 9);
		gpCreateBbox.add(rdoBboxType3, 0, 10);
		gpCreateBbox.add(rdoBboxType4, 0, 11);
		gpCreateBbox.add(btnCancelBackToMENU, 6, 11);
		gpCreateBbox.add(btnSubmitBB, 4, 11);
		gpCreateParty.add(lblCreateP, 2, 0);
		gpCreateParty.add(lblPartyName, 0, 3);
		gpCreateParty.add(lblTypeP, 0, 6);
		gpCreateParty.add(tfPartyName, 2, 3);
		gpCreateParty.add(rdoParty1, 0, 8);
		gpCreateParty.add(rdoParty2, 0, 9);
		gpCreateParty.add(rdoParty3, 0, 10);
		gpCreateParty.add(btnCancelBackToMENU3, 6, 11);
		gpCreateParty.add(btnSubmitP, 4, 11);
		gpMask.add(lblMask, 1, 0);
		gpMask.add(btnYesMask, 1, 4);
		gpMask.add(btnNoMask, 2, 4);
		gpIsSick.add(lblSick, 1, 0);
		gpIsSick.add(btnYesSick, 1, 4);
		gpIsSick.add(btnNoSick, 2, 4);
		gpIsCandSick.add(lblCandSick, 1, 0);
		gpIsCandSick.add(btnYesCandSick, 1, 4);
		gpIsCandSick.add(btnNoCandSick, 2, 4);
		gpCreateCitizen.add(lblCreateCIT, 2, 0);
		gpCreateSickCitizen.add(lblCreateCIT1, 2, 0);
		gpCreateCitizen.add(lblCitizenName, 0, 3);
		gpCreateSickCitizen.add(lblCitizenName1, 0, 3);
		gpCreateCitizen.add(tfCitizenName, 2, 3);
		gpCreateSickCitizen.add(tfCitizenName1, 2, 3);
		gpCreateCitizen.add(lblCitizenID, 0, 6);
		gpCreateSickCitizen.add(lblCitizenID1, 0, 6);
		gpCreateCitizen.add(tfCitizenID, 2, 6);
		gpCreateSickCitizen.add(tfCitizenID1, 2, 6);
		gpCreateCitizen.add(lblCitizenYOB, 0, 9);
		gpCreateSickCitizen.add(lblCitizenYOB1, 0, 9);
		gpCreateCitizen.add(tfCitizenYOB, 2, 9);
		gpCreateSickCitizen.add(tfCitizenYOB1, 2, 9);
		gpCreateSickCitizen.add(lblSickDays, 0, 12);
		gpCreateSickCitizen.add(tfSickDays, 2, 12);
		gpCreateCitizen.add(btnCancelBackToMENU1, 4, 15);
		gpCreateSickCitizen.add(btnCancelBackToMENU2, 4, 15);
		gpCreateCitizen.add(btnSubmitCIT, 2, 15);
		gpCreateSickCitizen.add(btnSubmitSickCIT, 2, 15);
		gpCreateCandidate.add(btnCancelBackToMENU5, 5, 22);
		gpCreateSickCandidate.add(btnCancelBackToMENU6, 6, 22);
		gpCreateCandidate.add(lblCreateCAND, 2, 0);
		gpCreateSickCandidate.add(lblCreateCAND1, 2, 0);
		gpCreateCandidate.add(lblCandName, 0, 3);
		gpCreateSickCandidate.add(lblCandName1, 0, 3);
		gpCreateCandidate.add(lblCandID, 0, 6);
		gpCreateSickCandidate.add(lblCandID1, 0, 6);
		gpCreateCandidate.add(lblCandYOB, 0, 9);
		gpCreateSickCandidate.add(lblCandYOB1, 0, 9);
		gpCreateCandidate.add(tfCandName, 3, 3);
		gpCreateSickCandidate.add(tfCandName1, 3, 3);
		gpCreateCandidate.add(tfCandID, 3, 6);
		gpCreateSickCandidate.add(tfCandID1, 3, 6);
		gpCreateCandidate.add(tfCandYOB, 3, 9);
		gpCreateSickCandidate.add(tfCandYOB1, 3, 9);
		gpCreateCandidate.add(lblPartyChoose, 0, 12);
		gpCreateSickCandidate.add(lblPartyChoose1, 0, 12);
		gpCreateSickCandidate.add(lblSickDays1, 0, 15);
		gpCreateSickCandidate.add(tfCandSickDays, 3, 15);
		gpCreateCandidate.add(btnSubmitCAND, 3, 22);
		gpCreateSickCandidate.add(btnSubmitSickCAND, 3, 22);
		gpShoWBB.add(TAShowBB, 0, 0);
		gpShoWBB.add(btnCancelBackToMENU4, 0, 3);
		gpShoWP.add(TAShowP, 0, 0);
		gpShoWP.add(btnCancelBackToMENU7, 0, 3);
		gpShoWCIT.add(TAShowCIT, 0, 0);
		gpShoWCIT.add(btnCancelBackToMENU8, 0, 3);
		gpShoWResult.add(TAShowResult, 0, 0);
		gpShoWResult.add(btnCancelBackToMENU9, 0, 3);
		gpLastChance.add(lbllastChance, 4, 0);
		gpLastChance.add(btnLastChanceY, 7, 1);
		gpLastChance.add(btnLastChanceN, 9, 1);
		gpVote.add(cmbPartiesVote, 8, 2);
		gpVote.add(lblVote, 3, 2);
		gpCreateSickCandidate.add(cmbParties, 3, 12);

		gpVote.add(btnNextVote, 8, 6);
		theStage.setScene(loadFile);
		theStage.show();

	}

	protected String getResultTostring() {
		StringBuffer str = new StringBuffer();
		for (UIEventListener l : listeners) {
			str.append(l.getResultTostring());
		}
		return str.toString();
	}

	protected String getCitizensTostring() {
		StringBuffer str = new StringBuffer();
		for (UIEventListener l : listeners) {
			str.append(l.getCitizensTostring());
		}
		return str.toString();
	}

	private void setStyleForTA(TextArea t) {
		t.setEditable(false);
		t.setStyle("-fx-font-size: 18; -fx-font-weight: Bold;  -fx-text-align: center;");
		t.setPrefSize(500, 610);
	}

	protected String getPartyTostring() {
		StringBuffer str = new StringBuffer();
		for (UIEventListener l : listeners) {
			str.append(l.getPartyTostring());
		}
		return str.toString();
	}

	private String getBboxTostring() {
		StringBuffer str = new StringBuffer();
		for (UIEventListener l : listeners) {
			str.append(l.getBboxTostring());
		}
		return str.toString();

	}

	@Override
	public void registerListener(ElectionsSystemController x) {
		this.listeners.add(x);

	}

	@Override
	public void addBboxToUI(String adress, String type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCitizenToUI(String name, String id, String type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPartyToUI(String name) {
		this.cmbParties.getItems().add(name);
		this.cmbPartiesVote.getItems().add(name);
		this.cmbParties1.getItems().add(name);

	}

	@Override
	public void addCandidateToUI(String name, String id, String partyBelong) {
		// TODO Auto-generated method stub

	}

	public void setupGridPane(GridPane gp, double x) {
		gp.setPadding(new Insets(x));
		gp.setHgap(x);
		gp.setVgap(x);
	}

	@Override
	public void loadEarlyElections(Vector<String> datesStrings) {

		this.cmbElectionArchive.getItems().addAll(datesStrings);

	}

	private void exceptionAlert(Exception e) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Exception alert");
		alert.setHeaderText("exception :");
		alert.setContentText(e.getMessage());
		((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(logo);
		alert.showAndWait();
	}

	private void loadSucssesAlert() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStyleClass().remove("alert");
		dialogPane.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		alert.setTitle("Goodbye");
		alert.setTitle("Sucsses");
		alert.setHeaderText("the object added sucssesfully");
		alert.setContentText("going back to menu");

		((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(logo);
		alert.showAndWait();
	}

	private void voteSucssesAlert() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStyleClass().remove("alert");
		dialogPane.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		alert.setTitle("Goodbye");
		alert.setTitle("elections end!");
		alert.setHeaderText("all the voters used their right to vote");
		alert.setContentText("going back to menu");

		((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(logo);
		alert.showAndWait();
	}

	private void quitApp(Stage s) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStyleClass().remove("alert");
		dialogPane.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		alert.setTitle("Goodbye");
		alert.setHeaderText("thank you for using our app");
		alert.setContentText("Elections systems ©");
		((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(logo);
		alert.showAndWait();
		s.close();
	}

	@Override
	public void loadCurrentParties(Vector<String> partyStringNames) {
		this.cmbParties.getItems().addAll(partyStringNames);
		this.cmbParties1.getItems().addAll(partyStringNames);
		

	}

	@Override
	public void addElectionsToUI(int y, int m, int limit) {
		if (cmbElectionArchive.getItems().size() > limit)
			cmbElectionArchive.getItems().add(cmbElectionArchive.getItems().size() + 1 + ") " + m + "/" + y);
	}

	@Override
	public void addElectionsToUI(int y, int m) {
		cmbElectionArchive.getItems().add(cmbElectionArchive.getItems().size() + 1 + ") " + m + "/" + y);
	}

}