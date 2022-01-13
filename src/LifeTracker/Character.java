package LifeTracker;

/***
 * represents the life and battle stats of a character in dnd
 * @author Lucas_C_Wright
 * @start 04-03-21
 * @version 04-03-21
 */
public class Character {
	private String name;
	private int maxLife;
	private int currLife;
	private int tempLife;
	private int armorClass;
	private int initiative;
	
	public Character() {
		name = "";
		maxLife = 1;
		currLife = 1;
		tempLife = 0;
		armorClass = 10;
		initiative = 1;
	}
	
	public Character(String nName, int nMax, int nArmor, int nInt) {
		name = nName;
		maxLife = nMax;
		currLife = nMax;
		tempLife = 0;
		armorClass = nArmor;
		initiative = nInt;
	}
	
	public void addLife() {
		if (currLife < maxLife) {
			currLife += 1;
		}
	}
	
	public void removeLife() {
		if (currLife > 0) {
			currLife -= 1;
		}
	}
	
	public void addTemp() {
		tempLife += 1;
	}
	
	public void removeTemp() {
		if (tempLife > 0) {
			tempLife -= 1;
		}
	}
	
	public void resetLife() {
		currLife = maxLife;
		tempLife = 0; 
	}
	
	public String getName() { return name; }
	
	public int getMax() { return maxLife; }
	
	public int getCurr() { return currLife; }
	
	public int getTemp() { return tempLife; }
	
	public int getArmor() { return armorClass; }
	
	public int getInitiative() { return initiative; }
	
	public void setName(String nName) { name = nName; }
	
	public boolean setMax(int nMax) {
		// the max life total must be more than zero
		if (nMax > 0) {
			maxLife = nMax;
			currLife = nMax;
			return true;
		}
		
		return false;
	}
	
	public boolean setCurr(int nCurr) {
		//the current life must be more than zero and less than the maximum life
		if (nCurr >= 0 && nCurr <= maxLife) {
			currLife = nCurr;
			return true;
		}

		return false;
	}
	
	public boolean setTemp(int nTemp) {
		if (nTemp > 0) {
			tempLife = nTemp;
			return true;
		}
		
		return false;
	}
	
	public boolean setArmor(int nArmor) {
		if (nArmor > 9 && nArmor <= 50) {
			armorClass = nArmor;
			return true;
		}
		
		return false;
	}
	
	public boolean SetInt(int nInt) {
		if (nInt > 0 && nInt < 40) {
			initiative = nInt;
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		return name + " " + maxLife + " " + currLife + " " + tempLife + " " + armorClass + " " + initiative; 
	}	
}