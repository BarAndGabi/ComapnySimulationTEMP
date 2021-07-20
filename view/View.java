package application.view;

import javafx.stage.Stage;

public class View implements AbstractView {

	public View(Stage theStage) {
		Scene g = new Scene();
		theStage.setScene(g);
		theStage.show();
	}

}
