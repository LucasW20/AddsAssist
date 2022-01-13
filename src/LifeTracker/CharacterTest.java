package LifeTracker;

import static org.junit.Assert.*;
import org.junit.Test;

public class CharacterTest {

	@Test
	public void testAddLife() {
		Character c1 = new Character("Joe", 5, 15, 9);
		c1.addLife();
		assertEquals(5, c1.getCurr());
		c1.removeLife();
		c1.removeLife();
		c1.addLife();
		c1.addLife();
		assertEquals(5, c1.getCurr());
		
		Character c2 = new Character();
		c2.removeLife();
		c2.removeLife();
		c2.removeLife();
		assertEquals(0, c2.getCurr());
	}

	@Test
	public void testResetLife() {
		Character c1 = new Character("joe", 10, 15, 9);
		c1.removeLife();
		c1.removeLife();
		c1.removeLife();
		c1.removeLife();
		c1.removeLife();
		c1.resetLife();
		
		assertEquals(10, c1.getCurr());
	}

	@Test
	public void testGetName() {
		Character c1 = new Character();
		Character c2 = new Character("", 1, 15, 9);
		assertEquals("", c1.getName());
		assertEquals("", c2.getName());
	}
	
	@Test
	public void testSetMax() {
		Character c1 = new Character();
		c1.setMax(50);
		assertEquals(50, c1.getMax());
		assertEquals(50, c1.getCurr());
		assertEquals(false, c1.setMax(-1));
		assertEquals(true, c1.setMax(1));
		assertEquals(true, c1.setMax(1));
		assertEquals(1, c1.getCurr());
	}

	@Test
	public void testSetCurr() {
		Character c1 = new Character();
		assertEquals(1, c1.getMax());
		assertEquals(false, c1.setCurr(10));
		assertEquals(false, c1.setCurr(-1));
		c1.setMax(50);
		assertEquals(true, c1.setCurr(30));
		assertEquals(30, c1.getCurr());
	}

	@Test
	public void testSetTemp() {
		Character c1 = new Character();
		assertTrue(c1.setTemp(10));
		assertFalse(c1.setTemp(-10));
	}

	@Test
	public void testSetArmor() {
		Character c1 = new Character();
		assertTrue(c1.setArmor(50));
		assertFalse(c1.setArmor(51));
		assertFalse(c1.setArmor(9));
		assertEquals(50, c1.getArmor());
	}

	@Test
	public void testSetInt() {
		Character c1 = new Character();
		assertTrue(c1.SetInt(15));
		assertFalse(c1.SetInt(-10));
		assertFalse(c1.SetInt(100));
		assertEquals(15, c1.getInitiative());
	}

	@Test
	public void testToString() {
		Character c1 = new Character();
		assertEquals(" 1 1 0 10 1", c1.toString());
		Character c2 = new Character("Josh,", 25, 17, 25);
		c2.setTemp(14);
		assertEquals("Josh, 25 25 14 17 25", c2.toString());
	}

}