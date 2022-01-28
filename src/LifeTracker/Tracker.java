package LifeTracker;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/***
 * single GUI for a character's information
 * 
 * @author Lucas_C_Wright
 * @start 05-03-21
 * @version 01-13-22
 */
public class Tracker extends GridPane {
	private Character charGUI;
	private Label currLife;
	private Label currTemp;

	/***
	 * constructor that sets up the GUI
	 */
	public Tracker(Character nCharGUI) {
		charGUI = nCharGUI;
		charGUI.resetLife();
		this.setPrefSize(180, 150);
		this.setMaxSize(180, 150);
		
		setStyle("-fx-border-color: black;");
		
		this.setPadding(new Insets(3, 3, 3, 3));
		this.setHgap(2);
		this.setVgap(2);
		
		addInfo();
		addLifeInteractables();
		addTempInteractables();
	}
	
	//returns the character that this class uses for its information
	public Character getChar() { return charGUI; }

	//sets up the information from the character that doesn't change in the GUI
	private void addInfo() {
		//setup the name
		Text tName = new Text(charGUI.getName());
		tName.setStyle("-fx-font: 20 ariel;");
		GridPane.setColumnSpan(tName, 5);
		GridPane.setHalignment(tName, HPos.CENTER);
		add(tName, 0, 0);

		//sets up the text for the armor
		Text tArmor = new Text("Armor: " + charGUI.getArmor());
		tArmor.setStyle("-fx-font: 20 ariel;");
		GridPane.setColumnSpan(tArmor, 5);
		GridPane.setHalignment(tArmor, HPos.CENTER);
		add(tArmor, 0, 3);

		//sets up the text for the initiative
		Text tInt = new Text("Initiative: " + charGUI.getInitiative());
		tInt.setStyle("-fx-font: 20 ariel;");
		GridPane.setColumnSpan(tInt, 5);
		GridPane.setHalignment(tInt, HPos.CENTER);
		add(tInt, 0, 4);
	}

	//sets up the information for the character that does change. I.E. the life
	private void addLifeInteractables() {
		Button minusLife = new Button("-");
		minusLife.setPrefSize(30, 30);
		minusLife.setId("life_-");
		minusLife.setOnAction(this::subtract);
		
		Button minusLifeTen = new Button("--");
		minusLifeTen.setPrefSize(35, 35);
		minusLifeTen.setId("life_-10");
		minusLifeTen.setOnAction(this::subtract);

		Button plusLife = new Button("+");
		plusLife.setPrefSize(30, 30);
		plusLife.setId("life_+");
		plusLife.setOnAction(this::addition);

		Button plusLifeTen = new Button("++");
		plusLifeTen.setPrefSize(35, 35);
		plusLifeTen.setId("life_+10");
		plusLifeTen.setOnAction(this::addition);

		currLife = new Label("" + charGUI.getMax());
		currLife.setStyle("-fx-font: 20 ariel;");

		add(minusLifeTen, 0, 1);
		add(minusLife, 1, 1);
		add(currLife, 2, 1);
		add(plusLife, 3, 1);
		add(plusLifeTen, 4, 1);
	}
	
	//sets up the information for the character that does change. I.E. the temporary life
	private void addTempInteractables() {
		//temp life
		Button minusTemp = new Button("-");
		minusTemp.setId("temp_-");
		minusTemp.setPrefSize(30, 30);
		minusTemp.setOnAction(this::subtractTemp);
		
		Button minusTempTen = new Button("--");
		minusTempTen.setId("temp_-10");
		minusTempTen.setPrefSize(35, 35);
		minusTempTen.setOnAction(this::subtractTemp);

		Button plusTemp = new Button("+");
		plusTemp.setId("temp_+");
		plusTemp.setPrefSize(30, 30);
		plusTemp.setOnAction(this::additionTemp);
		
		Button plusTempTen = new Button("++");
		plusTempTen.setId("temp_+10");
		plusTempTen.setPrefSize(35, 35);
		plusTempTen.setOnAction(this::additionTemp);
		
		currTemp = new Label("" + charGUI.getTemp());
		currTemp.setStyle("-fx-font: 20 ariel;");
		
		
		add(minusTempTen, 0, 2);
		add(minusTemp, 1, 2);
		add(currTemp, 2, 2);
		add(plusTemp, 3, 2);
		add(plusTempTen, 4, 2);
	}

	//handles the event for when the user presses one of the minus buttons 
	private void subtract(ActionEvent e) {
		//if the source of the event came from a button then continue
		if (e.getSource() instanceof Button) {
			Button source = (Button) e.getSource();
			
			if (source.getId() == "life_-10") { //if the source is the minus 10 button then remove 10 life using a loop
				for (int i = 0; i < 10; i++) {
					charGUI.removeLife();
				}
			} else { //if the source is just the regular minus button then remove 1 life
				charGUI.removeLife();
			}
			
			//update the GUI texts
			currLife.setText("" + charGUI.getCurr());
		}
	}

	private void addition(ActionEvent e) {
		if (e.getSource() instanceof Button) {
			Button source = (Button) e.getSource();
			if (source.getId() == "life_+10") {
				for (int i = 0; i < 10; i++) {
					charGUI.addLife();
				}
			} else {
				charGUI.addLife();
			}
			
			currLife.setText("" + charGUI.getCurr());
		}
	}

	private void subtractTemp(ActionEvent e) {
		if (e.getSource() instanceof Button) {
			Button source = (Button) e.getSource();
			if (source.getId() == "temp_-10") {
				for (int i = 0; i < 10; i++) {
					charGUI.removeTemp();
				}
			} else {
				charGUI.removeTemp();
			}
			
			currTemp.setText("" + charGUI.getTemp());
		}
	}

	private void additionTemp(ActionEvent e) {
		if(e.getSource() instanceof Button) {
			Button source = (Button) e.getSource();
			if (source.getId() == "temp_+10") {
				for (int i = 0; i < 10; i++) {
					charGUI.addTemp();
				}
			} else {
				charGUI.addTemp();
			}
			
			currTemp.setText("" + charGUI.getTemp());
		}
	}
}