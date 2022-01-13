package LifeTracker;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/***
 * Window to create a new character
 * 
 * @author Lucas_C_Wright
 * @version 04-19-21
 */
public class NewCharUI extends Application {

	private Stage mainStage;
	private TextField eName;
	private TextField eLife;
	private TextField eArmor;
	private TextField eInt;
	private Text nameBad;
	private Text lifeBad;
	private Text armorBad;
	private Text intBad;
	private Button create;
	private Character nChar;
	
	public NewCharUI(Stage nStage) {
		try {
			start(nStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start(Stage nStage) throws Exception {
		mainStage = nStage;

		GridPane createCharacter = new GridPane();
		createCharacter.setMinWidth(150);
		createCharacter.setHgap(2);
		createCharacter.setVgap(2);
		createCharacter.setPadding(new Insets(3, 3, 3, 3));

		Text createPrompt = new Text("Add New Character");
		GridPane.setColumnSpan(createPrompt, 2);
		createPrompt.setTextAlignment(TextAlignment.CENTER);
		createCharacter.add(createPrompt, 0, 0);

		eName = new TextField();
		eName.setPrefWidth(100);
		eName.setPromptText("Name");
		createCharacter.add(eName, 0, 1);

		eLife = new TextField();
		eLife.setPrefWidth(100);
		eLife.setPromptText("Max Life");
		eLife.setOnKeyTyped(this::validateInput);
		createCharacter.add(eLife, 0, 2);

		eArmor = new TextField();
		eArmor.setPrefWidth(100);
		eArmor.setPromptText("Armor Class");
		eArmor.setOnKeyTyped(this::validateInput);
		createCharacter.add(eArmor, 0, 3);

		eInt = new TextField();
		eInt.setPrefWidth(100);
		eInt.setPromptText("Initiative");
		eInt.setOnKeyTyped(this::validateInput);
		createCharacter.add(eInt, 0, 4);

		create = new Button();
		create.setOnAction(this::createChar);
		create.setText("Create");
		create.setDisable(true);
		createCharacter.add(create, 0, 5);

		Button cancel = new Button();
		cancel.setOnAction(this::cancelChar);
		cancel.setText("Cancel");
		createCharacter.add(cancel, 1, 5);

		nameBad = new Text("Invalid");
		nameBad.setVisible(false);
		createCharacter.add(nameBad, 1, 1);

		lifeBad = new Text("Invaild");
		lifeBad.setVisible(false);
		createCharacter.add(lifeBad, 1, 2);

		armorBad = new Text("Invalid");
		armorBad.setVisible(false);
		createCharacter.add(armorBad, 1, 3);

		intBad = new Text("Invalid");
		intBad.setVisible(false);
		createCharacter.add(intBad, 1, 4);

		Scene scene = new Scene(createCharacter);
		mainStage.setScene(scene);
		mainStage.show();
	}
	
	public Character getChar() {
		if (nChar != null) {
			return nChar;
		}
		
		return null;
	}

	public void createChar(ActionEvent e) {
		if (e.getSource() instanceof Button) {
			String nName = eName.getText();
			int nLife = Integer.parseInt(eLife.getText());
			int nArmor = Integer.parseInt(eArmor.getText());
			int nInt = Integer.parseInt(eInt.getText());

			nChar = new Character(nName, nLife, nArmor, nInt);
		}
	}

	public void cancelChar(ActionEvent e) {
		if (e.getSource() instanceof Button) {
			mainStage.close();
		}
	}

	public boolean validateLife() {
		// try to parse the double
		try {
			Integer.parseInt(eLife.getText());

			// if the parse works then enable the button and change the
			// style back to normal
			lifeBad.setVisible(false);
			eLife.setStyle("");
			return true;
		} catch (NumberFormatException ex) {
			// if the parse doesn't work then disable the button and change
			// the text in the TextField to red
			lifeBad.setVisible(true);
			eLife.setStyle("-fx-text-inner-color : red");
			return false;
		}
	}

	public boolean validateArmor() {
		try {
			Integer.parseInt(eArmor.getText());

			// if good
			armorBad.setVisible(false);
			eArmor.setStyle("");
			return true;
		} catch (NumberFormatException ex) {
			// if bad
			armorBad.setVisible(true);
			eArmor.setStyle("-fx-text-inner-color : red");
			return false;
		}
	}

	private boolean validateInt() {
		try {
			Integer.parseInt(eInt.getText());

			// if good
			intBad.setVisible(false);
			eInt.setStyle("");
			return true;
		} catch (NumberFormatException ex) {
			// if bad
			intBad.setVisible(true);
			eInt.setStyle("-fx-text-inner-color : red");
			return false;
		}
	}
	
	private boolean validateName() {
		if (eName.getText().length() >= 15) {
			nameBad.setVisible(true);
			eName.setStyle("-fx-text-inner-color : red");
			return false;
		} else {
			nameBad.setVisible(false);
			eName.setStyle("");
			return true;
		}
	}

	private void validateInput(KeyEvent e) {
		if (e.getSource() instanceof TextField) {
			if (validateLife() && validateArmor() && validateInt() && validateName()) {
				create.setDisable(false);
			} else {
				create.setDisable(true);
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}