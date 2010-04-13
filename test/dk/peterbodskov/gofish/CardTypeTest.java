package dk.peterbodskov.gofish;

import junit.framework.TestCase;

public class CardTypeTest extends TestCase {
	private CardType cardType;

	@Override
	protected void setUp() throws Exception {
		cardType = new CardType();
	}
	
	public void testIsPair(){
		assertFalse(cardType.isPair());
	}
	
	public void testAddCard(){
		cardType.addCard(new Card(3));
		assertTrue(cardType.getSize() == 1);
		assertFalse(cardType.isPair());
	}
	
}
