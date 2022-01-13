package LifeTracker;

import static org.junit.Assert.*;
import org.junit.Test;

public class CharacterListTest {

	@Test
	public void testCharacterList() {
		CharacterList l1 = new CharacterList();
		assertEquals(0, l1.getNumChars());
	}

	@Test
	public void testAddChar() {
		CharacterList l1 = new CharacterList();
		Character c1 = new Character("h", 23, 21, 5);
		Character c2 = new Character();
		l1.addChar(c1);
		l1.addChar(c2);
		l1.addChar(c1);
		assertEquals(c1, l1.getChar(0));
		assertEquals(c1, l1.getChar(2));
		assertEquals(c2, l1.getChar(1));
		assertEquals(3, l1.getNumChars());
		
		try {
			assertEquals(c1, l1.getChar(5));
		} catch (ArrayIndexOutOfBoundsException e) {
			//all good
		} catch (Exception e) {
			fail("Wrong exception thrown.");
		}
	}

	@Test
	public void testFindChar() {
		CharacterList l1 = new CharacterList();
		Character c1 = new Character("h", 23, 21, 5);
		Character c2 = new Character();
		l1.addChar(c1);
		l1.addChar(c2);
		l1.addChar(c1);
		assertEquals(c2, l1.findChar(""));
		assertNull(l1.findChar("georg"));
	}

	@Test
	public void testReset() {
		CharacterList l1 = new CharacterList();
		Character c1 = new Character("h", 23, 21, 5);
		Character c2 = new Character();
		l1.addChar(c1);
		l1.addChar(c2);
		l1.addChar(c1);
		l1.reset();
		assertEquals(0, l1.getNumChars());
		try { 
			assertNull(l1.getChar(1));
		} catch (ArrayIndexOutOfBoundsException e) {
			//all good
		} catch (Exception e) {
			fail("Wrong Exception");
		}
	}
}
