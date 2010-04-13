package dk.peterbodskov.gofish;

public class Player {
	private String name;
	private Hand hand;
	private Table table;
	private int numberOfPairs;
	
	public Player(String name, Table table){
		this.name = name;
		hand = new Hand();
		this.table = table;
		numberOfPairs = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public int getNumberOfPairs() {
		return numberOfPairs;
	}

	public void setNumberOfPairs(int numberOfPairs) {
		this.numberOfPairs = numberOfPairs;
	}
	
	public boolean askForCards(Player playerToAsk){
		int number = hand.findCardsToAskFor();
		System.out.println(name + " is asking " + playerToAsk.getName() + " for " +  number + "'s");
		if(playerToAsk.hasCards(number)){
			System.out.println(playerToAsk.getName() + " has some of these cards");
			getHand().addListOfCards(playerToAsk.getHand().removeCards(number));
			return true;
		}
		System.out.println(playerToAsk.getName() + " has no " + number + "'s");
		return false;
	}
	
	public void playRound(Player playerToAsk){
		boolean shouldGoFish = ! askForCards(playerToAsk);
		if(shouldGoFish){
			goFish();
		}
		int pairFound = hand.checkForPair();
		if(pairFound > 0){
			removePairFromHandAndUpdateScore(pairFound);
		}
	}

	private void removePairFromHandAndUpdateScore(int pairFound) {
		System.out.println("** " + name + " has got a pair of " + pairFound + "'s");
		hand.removePairFromHand(pairFound);
		numberOfPairs += 1;
	}

	private void goFish() {
		getHand().addSingleCard(table.getCard());
	}

	private boolean hasCards(int number) {
		return getHand().getNumberOfCardsOfSpecificType(number) > 0;
		
	}


}
