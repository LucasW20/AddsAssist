package LifeTracker;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/***
 * creates a GUI for the life tracker app.
 * contains controls for the side as well as a GUI for each tracker
 * 
 * @author Lucas_C_Wright
 * @start 04-21-21
 * @version 09-12-21
 */
public class LifeTracker extends Application {
	private Stage mainStage;
	private BorderPane window;
	private GridPane controls;
	private GridPane screen;
	
	private TextField eName;
	private TextField eLife;
	private TextField eArmor;
	private TextField eInt;
	private Text invalid;
	
	private int numTrackers;
	private int row = 0;
	private int column = 0;
	
	public void start(Stage nStage) throws Exception {
		numTrackers = 0;
		mainStage = nStage;
		
		window = new BorderPane();
		window.setPrefSize(821, 320);
		addControls();
		
		screen = new GridPane();
		
		/*
		//15 char limit
		Character georg = new Character("gesrfs", 999, 12, 10);
		Tracker test = new Tracker(georg);
		screen.add(test, 0, 0);
		*/
		
		window.setLeft(controls);
		window.setCenter(screen);
		
		Scene scene = new Scene(window);
		mainStage.setScene(scene);
		mainStage.setTitle("DnD Life Tracker");
		mainStage.show();
	}
	
	private void addControls() {
		controls = new GridPane();
		
		Text title = new Text("Controls");
		controls.add(title, 0, 0);
		
		/*
		Button newChar = new Button("New");
		newChar.setPrefWidth(100);
		newChar.setOnAction(this::newCharacter);
		newChar.setId("new");
		controls.add(newChar, 0, 1);
		*/
		
		Button editChar = new Button("Edit");
		editChar.setPrefWidth(100);
		editChar.setId("edit");
		controls.add(editChar, 0, 1);
		
		Button removeChar = new Button("Remove");
		removeChar.setPrefWidth(100);
		removeChar.setId("remove");
		controls.add(removeChar, 0, 2);
		
		Button close = new Button("Close");
		close.setPrefWidth(100);
		close.setOnAction(this::closeWindow);
		close.setId("close");
		controls.add(close, 0, 3);
		
		//controls for adding new character
		Text createPrompt = new Text("New Character");
		controls.add(createPrompt, 0, 4);
		
		eName = new TextField();
		eName.setPrefWidth(100);
		eName.setPromptText("Name");
		controls.add(eName, 0, 5);
		
		eLife = new TextField();
		eLife.setPrefWidth(100);
		eLife.setPromptText("Max Life");
		//eLife.setOnKeyTyped(this::validateInput);
		controls.add(eLife, 0, 6);

		eArmor = new TextField();
		eArmor.setPrefWidth(100);
		eArmor.setPromptText("Armor Class");
		//eArmor.setOnKeyTyped(this::validateInput);
		controls.add(eArmor, 0, 7);

		eInt = new TextField();
		eInt.setPrefWidth(100);
		eInt.setPromptText("Initiative");
		//eInt.setOnKeyTyped(this::validateInput);
		controls.add(eInt, 0, 8);

		Button create = new Button();
		create.setOnAction(this::createChar);
		create.setText("Create");
		create.setPrefWidth(100);
		controls.add(create, 0, 9);
		
		invalid = new Text("");
		invalid.setWrappingWidth(100);
		controls.add(invalid, 0, 10);
	}
	
	public void createChar(ActionEvent e) {
		if (e.getSource() instanceof Button) {
			//checks if there is an available spot for the new character
			if (numTrackers < 8) {
				//get the new character info from the text fields and store them
				String nName = eName.getText();
				int nLife = Integer.parseInt(eLife.getText());
				int nArmor = Integer.parseInt(eArmor.getText());
				int nInt = Integer.parseInt(eInt.getText());

				//create the new character and the tracker for that character
				Character nChar = new Character(nName, nLife, nArmor, nInt);
				Tracker nTrack = new Tracker(nChar);
				
				//screen.add(nTrack, 1, 0);  only adds the character to one spot
				screen.add(nTrack, column, row);
				
				//update the gridpane coord variables for the next character. 4 characters per row. 
				if (column == 3) {
					column = 0;
					row = 1;
				} else {
					column++;
				}
				
				//update the number of trackers on the screen
				numTrackers++;
			} else {
				System.out.println("Already at max capacity. Cannot add more trackers.");
				invalid.setText("Cannot add anymore characters!");
			}
		}
	}
	
	
	private void closeWindow(ActionEvent e) {
		if (e.getSource() instanceof Button) {
			mainStage.close();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}