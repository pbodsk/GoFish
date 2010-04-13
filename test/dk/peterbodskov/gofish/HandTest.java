package dk.peterbodskov.gofish;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

public class HandTest extends TestCase {
	private Hand hand;

	@Override
	protected void setUp() throws Exception {
		hand = new Hand();
	}
	
	public void testGetSize(){
		assertEquals(Hand.CARDS_IN_GAME, hand.getSize());
	}
	
	public void testAddSingleCard(){
		Card card = new Card(1);
		assertEquals(0, hand.getNumberOfCardsOfSpecificType(1));
		hand.addSingleCard(card);
		assertEquals(1, hand.getNumberOfCardsOfSpecificType(1));
	}
	
	public void testAddCardList(){
		List<Card> cardsToAdd = new LinkedList<Card>();
		assertEquals(0, hand.getNumberOfCardsOfSpecificType(1));
		cardsToAdd.add(new Card(1));
		cardsToAdd.add(new Card(1));
		hand.addListOfCards(cardsToAdd);
		assertEquals(2, hand.getNumberOfCardsOfSpecificType(1));
		assertFalse(hand.hasPair(1));
	}
	
	public void testRemoveCards(){
		List<Card> cardsToAdd = new LinkedList<Card>();
		assertEquals(0, hand.getNumberOfCardsOfSpecificType(1));
		cardsToAdd.add(new Card(1));
		cardsToAdd.add(new Card(1));
		hand.addListOfCards(cardsToAdd);
		assertEquals(2, hand.getNumberOfCardsOfSpecificType(1));
		hand.removeCards(1);
		assertEquals(0, hand.getNumberOfCardsOfSpecificType(1));
	}
	
	public void testHasPair(){
		List<Card> cardsToAdd = new LinkedList<Card>();
		assertEquals(0, hand.getNumberOfCardsOfSpecificType(1));
		cardsToAdd.add(new Card(1));
		cardsToAdd.add(new Card(1));
		cardsToAdd.add(new Card(1));
		cardsToAdd.add(new Card(1));
		hand.addListOfCards(cardsToAdd);
		assertEquals(4, hand.getNumberOfCardsOfSpecificType(1));
		assertTrue(hand.hasPair(1));
	}
	
	public void testCheckForPairTrue(){
		createTestPair(11);
		assertEquals(11, hand.checkForPair());
	}
	
	public void testCheckForPairFalse(){
		List<Card> cardsToAdd = new LinkedList<Card>();
		assertEquals(0, hand.getNumberOfCardsOfSpecificType(1));
		cardsToAdd.add(new Card(11));
		cardsToAdd.add(new Card(11));
		cardsToAdd.add(new Card(11));
		hand.addListOfCards(cardsToAdd);
		assertEquals(0, hand.checkForPair());
	}
	
	public void testRemovePairFromHand(){
		createTestPair(12);
		List res = hand.removePairFromHand(12);
		assertEquals(4, res.size());
		assertEquals(0, hand.getNumberOfCardsOfSpecificType(12));
	}

	private void createTestPair(int number) {
		List<Card> cardsToAdd = new LinkedList<Card>();
		assertEquals(0, hand.getNumberOfCardsOfSpecificType(1));
		cardsToAdd.add(new Card(number));
		cardsToAdd.add(new Card(number));
		cardsToAdd.add(new Card(number));
		cardsToAdd.add(new Card(number));
		hand.addListOfCards(cardsToAdd);
	}
}
