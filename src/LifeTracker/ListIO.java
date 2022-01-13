package LifeTracker;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * loads and saves CharacterLists
 * 
 * @author Lucas_C_Wright
 * @version 04-04-21
 */
public class ListIO {
	public boolean saveCharacters(CharacterList sList, String fileName) {
		if (sList == null || fileName == null) {
			return false;
		}
		
		File sFile = new File(fileName);
		try {
			if (sFile.createNewFile()) {
				//save
				PrintWriter output = new PrintWriter(sFile);
				for (int i = 0; i < sList.getNumChars(); i++) {
					output.println(sList.getChar(i).toString());
				}
				
				output.close();
				return true;
			}
			else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean loadCharacters(String fileName) {
		return false;
	}
}
