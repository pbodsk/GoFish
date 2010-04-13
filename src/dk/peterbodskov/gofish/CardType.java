package dk.peterbodskov.gofish;

import java.util.LinkedList;
import java.util.List;

public class CardType {
	private static final int PAIR_SIZE = 4;
	private List<Card> numberOfCards;
	
	public CardType(){
		numberOfCards = new LinkedList<Card>();
	}
	
	public boolean isPair(){
		return numberOfCards.size() == PAIR_SIZE;
	}
	
	public void addCard(Card card){
		numberOfCards.add(card);
	}
	
	public void addListOfCards(List<Card> cards){
		numberOfCards.addAll(cards);
	}
	
	public int getSize(){
		return numberOfCards.size();
	}
	
	public List<Card> getCards(){
		return numberOfCards;
	}
}
