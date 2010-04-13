package dk.peterbodskov.gofish;

import junit.framework.TestCase;

public class CardTest extends TestCase {
	public void testCreate(){
		Card card = new Card(1);
		assertEquals(1, card.getNumber());
	}
	
	public void testSet(){
		Card card = new Card(2);
		assertEquals(2, card.getNumber());
		card.setNumber(3);
		assertEquals(3, card.getNumber());
	}
	
	public void testInvalidCard(){
		try {
			Card card = new Card(14);
			fail("shouldn't get here");
		} catch(InvalidCardException ex) {
			
		}
	}
}
