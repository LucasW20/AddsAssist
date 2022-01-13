package LifeTracker;

/***
 * represents a list of characters
 * 
 * @author Lucas_C_Wright
 * @version 04-03-21
 */
public class CharacterList {
	private Character[] charList;
	private int numChars;
	
	public CharacterList() {
		charList = new Character[2];
		numChars = 0;
	}
	
	public void addChar(Character nChar) {
		//if the array is full then grow it
		if (charList.length == numChars) {
			growArray();
		}
		
		//add the new character to the array and then increase the numChars variable
		charList[numChars] = nChar;
		numChars++;
	}
	
	private void growArray() {
		//make a bigger array
		Character[] nList = new Character[numChars + 2];
		//copy the characters over to the new array
		for (int i = 0; i < numChars; i++) {
			nList[i] = charList[i];
		}
		//update the pointer
		charList = nList;
	}
	
	public Character getChar(int pos) {
		//checks if the passed position is within the array bounds
		if (pos >= numChars || pos < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		return charList[pos];
	}
	
	public int getNumChars() {
		return numChars;
	}
	
	public Character findChar(String name) {
		for (int i = 0; i < numChars; i++) {
			if (name.equals(charList[i].getName())) {
				return charList[i];
			}
		}
		
		return null;
	}
	
	public void reset() {
		numChars = 0;
		charList = new Character[2];
	}
}
