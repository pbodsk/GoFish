package dk.peterbodskov.gofish;

public class InvalidCardException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidCardException(){
		super("Card value must be between 1 and 13");
	}
}
