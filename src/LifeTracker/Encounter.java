package LifeTracker;

import java.util.ArrayList;
import javafx.scene.layout.FlowPane;

/***
 * makes a GUI for a entire encounter
 * 
 * @author Lucas_C_Wright
 * @version 05-04-21
 */
public class Encounter extends FlowPane {
	private ArrayList<Tracker> charsGUIs;
	
	public Encounter() {
	}
	
	private void show() {
		for (int i = 0; i < charsGUIs.size(); i++) {
			this.getChildren().add(charsGUIs.get(i));
		}
	}
	
	/***
	 * adds a character to the array and then adds it t
	 * @param nCh the new character being added to the array
	 */
	public void addCharacter(Character nCh) {
		Tracker nTrack = new Tracker(nCh);
		charsGUIs.add(nTrack);
		
		show();
	}
	
	public void removeCharacter(Character rCh) {
		//look for the character matching the parameter
		for (int i = 0; i < charsGUIs.size(); i++) {
			
		}
	}
}