package dk.peterbodskov.gofish;

public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Table table = new Table();
		Player peter = new Player("Peter", table);
		Player freja = new Player("Freja", table);
		setup(table, peter, freja);
		while(table.hasMoreCards()){
			peter.playRound(freja);
			System.out.println("Peter done, no of pairs: " + peter.getNumberOfPairs());
			freja.playRound(peter);
			System.out.println("Freja done, no of pairs: " + freja.getNumberOfPairs());
		}
		System.out.println("Game has ended, score");
		System.out.println("Peter : " + peter.getNumberOfPairs());
		System.out.println("Freja : " + freja.getNumberOfPairs());
		System.out.println("Ok...done");
	}

	private static void setup(Table table, Player peter, Player freja) {
		for(int i = 0; i < 5; i++){
			peter.getHand().addSingleCard(table.getCard());
			freja.getHand().addSingleCard(table.getCard());
		}
	}

}
