package splashcalendar.exceptions;

import splashcalendar.Artist;

public class NoGigInfoFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6256480620267788954L;

	public NoGigInfoFoundException(Artist a) {
		super("No Gig info found for Artist " + a.name);
	}
}
