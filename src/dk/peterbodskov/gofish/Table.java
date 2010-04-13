package dk.peterbodskov.gofish;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class Table {
	private List<Card> cards;
	private Logger log;
	
	public Table() {
		log = Logger.getLogger("Table.class");
		cards = new LinkedList<Card>();
		setupTable();
	}
	
	private void setupTable(){
		for(int i = 0; i < 13; i++){
			for(int j = 0; j < 4; j++){
				cards.add(new Card(i + 1));
			}
		}
	}
	
	public int getCardsOnTable(){
		return cards.size();
	}
	
	public Card getSpecificCard(int pos){
		return cards.get(pos);
	}
	
	public Card getCard() {
		int value = calculateRandomNumber();
		/*
		if(cards.size() > 0){
			System.out.println("Trying to remove card number " + value + " number of cards is " + cards.size());
			return cards.remove(value);
		}
		return null;
		*/
		System.out.println("Trying to remove card number " + value + " number of cards is " + cards.size());
		return cards.remove(value);
	}
	
	private int calculateRandomNumber(){
		return (int) (Math.random() * cards.size());
	}
	
	public boolean hasMoreCards(){
		return cards.size() > 0;
	}
	
	@Override
	public String toString() {
		return "There are now " + cards.size() + " left on the table";
	}
	
	
}
