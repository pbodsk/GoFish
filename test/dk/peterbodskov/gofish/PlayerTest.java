package dk.peterbodskov.gofish;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	private Player peter;
	private Player freja;
	private Table table;

	@Override
	protected void setUp() throws Exception {
		table = new Table();
		peter = new Player("Peter", table);
		freja = new Player("Freja", table);
	}
	
	public void testCreation(){
		assertEquals("Peter", peter.getName());
		assertEquals(0, peter.getNumberOfPairs());
	}
	
	public void testAskForCards(){
		setupPlayers(1,1, 1, 2);
		peter.askForCards(freja);
		assertEquals(3, peter.getHand().getNumberOfCardsOfSpecificType(1));
		assertEquals(0, freja.getHand().getNumberOfCardsOfSpecificType(1));
	}

	private void setupPlayers(int cardsForPlayerOne, int numberOfCardsForPlayerOne, int cardsForPlayerTwo, int numberOfCardsForPlayerTwo) {
		List<Card> petersCards = new LinkedList<Card>();
		List<Card> frejasCards = new LinkedList<Card>();
		for(int i = 0; i < numberOfCardsForPlayerOne; i++){
			petersCards.add(new Card(cardsForPlayerOne));	
		}
		peter.getHand().addListOfCards(petersCards);
		assertEquals(numberOfCardsForPlayerOne, peter.getHand().getNumberOfCardsOfSpecificType(cardsForPlayerOne));
		
		for(int i = 0; i < numberOfCardsForPlayerTwo; i++){
			frejasCards.add(new Card(cardsForPlayerTwo));
		}
		freja.getHand().addListOfCards(frejasCards);
		assertEquals(numberOfCardsForPlayerTwo, freja.getHand().getNumberOfCardsOfSpecificType(cardsForPlayerTwo));
	}
	
	public void testGoFish(){
		setupPlayers(1, 1, 2, 1);
		assertEquals(1, peter.getHand().getNumberOfCardsOnHand());
		peter.playRound(freja);
		assertEquals(2, peter.getHand().getNumberOfCardsOnHand());
	}
	
	public void testPairFound(){
		assertEquals(0, peter.getNumberOfPairs());
		setupPlayers(3, 2, 3, 2);
		peter.playRound(freja);
		assertEquals(1, peter.getNumberOfPairs());
	}
}
