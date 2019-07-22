package splashcalendar;

/**
 * Representation of an Artist with Name and Gig
 * @author Paul Dowideit (paul.dowideit@mat-traffic.de)
 *
 */
public class Artist {
	public final String name;
	public final String url;
	Gig gig;
	
	public Artist(String name, String url) {
		this.name = name;
		this.url = url;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
