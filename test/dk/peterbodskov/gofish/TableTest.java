package dk.peterbodskov.gofish;

import junit.framework.TestCase;

public class TableTest extends TestCase {
	private Table table;
	@Override
	protected void setUp() throws Exception {
		table = new Table();
	}

	public void testSetup(){	
		assertEquals(52, table.getCardsOnTable());
	}
	
	public void testVariousCards() {
		assertEquals(1, table.getSpecificCard(0).getNumber());
		assertEquals(1, table.getSpecificCard(2).getNumber());
		assertEquals(2, table.getSpecificCard(4).getNumber());
	}
	
	public void testGetCard() {
		assertEquals(52, table.getCardsOnTable());
		table.getCard();
		assertEquals(51, table.getCardsOnTable());
		table.getCard();
		assertEquals(50, table.getCardsOnTable());
		table.getCard();
		assertEquals(49, table.getCardsOnTable());
		table.getCard();
		assertEquals(48, table.getCardsOnTable());
		table.getCard();
		assertEquals(47, table.getCardsOnTable());
	}
	
	public void testHasMoreCards(){
		assertTrue(table.hasMoreCards());
	}
}
