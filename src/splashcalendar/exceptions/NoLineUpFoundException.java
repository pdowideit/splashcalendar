package splashcalendar.exceptions;

public class NoLineUpFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4414289925412371097L;

	public NoLineUpFoundException() { super("No Lineup found on given url"); }
}
