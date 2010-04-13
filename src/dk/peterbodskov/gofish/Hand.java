package dk.peterbodskov.gofish;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hand {
	public static final int CARDS_IN_GAME = 13;
	private Map<Integer, CardType> cards;
	private int lastAskedFor;
	
	public Hand(){
		cards = new HashMap<Integer, CardType>();
		initializeCardsMap();
		lastAskedFor = 0;
	}

	private void initializeCardsMap() {
		for(int i = 0; i < CARDS_IN_GAME; i++){
			cards.put(i + 1, new CardType());
		}
	}
	
	public int getSize(){
		return cards.size();
	}
	
	public int getNumberOfCardsOnHand(){
		int res = 0;
		for(int i : cards.keySet()){
			res += cards.get(i).getSize();
		}
			
		return res;
	}
	
	public int getNumberOfCardsOfSpecificType(int number){
		CardType cardType = cards.get(number);
		return cardType != null ? cardType.getSize() : 0;
	}
	
	public boolean hasPair(int numberToCheckFor){
		return cards.get(numberToCheckFor).isPair();
	}
	
	public void addSingleCard(Card card){
		CardType cardType = cards.get(card.getNumber());
		cardType.addCard(card);
		cards.put(card.getNumber(), cardType);
	}
	
	public void addListOfCards(List<Card> cardsToAdd){
		int cardValue = cardsToAdd.get(0).getNumber();
		CardType cardType = cards.get(cardValue);
		cardType.addListOfCards(cardsToAdd);
		cards.put(cardValue, cardType);
	}
	
	public List<Card> removeCards(int number){
		System.out.println("***** removing cards with number " + number);
		CardType cardType = cards.get(number);
		cards.remove(number);
		cards.put(number, new CardType());
		return cardType.getCards();
	}
	
	public int checkForPair(){
		int res = 0;
		for(int i : cards.keySet()){
			if(hasPair(i)){
				res = i;
			}
		}
		return res;
	}
	
	public List<Card> removePairFromHand(int numberToRemove){
		return removeCards(numberToRemove);
	}
	
	public int findCardsToAskFor() {
		int numberOfCardsOfType = 0;
		int valueToAskFor = 0;
		for(int i : cards.keySet()){
			if(cards.get(i).getSize() > numberOfCardsOfType && i != lastAskedFor){
				numberOfCardsOfType = cards.get(i).getSize();
				valueToAskFor = i;
				lastAskedFor = i;
			}
		}
		return valueToAskFor;
	}
}
