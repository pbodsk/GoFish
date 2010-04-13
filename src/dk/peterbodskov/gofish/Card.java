package dk.peterbodskov.gofish;

public class Card {
	private int number;
	
	public Card(int number){
		checkAndSetIfValueOk(number);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		checkAndSetIfValueOk(number);
	}
	
	private void checkAndSetIfValueOk(int value){
		if(value >=1 && value < 14){
			this.number = value;
		} else {
			throw new InvalidCardException();
		}
	}
	
	@Override
	public String toString(){
		return "Card with number " + this.number;
	}
}
