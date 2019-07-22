package splashcalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representation of a splash gig containing time and stage
 * @author Paul Dowideit (paul.dowideit@mat-traffic.de)
 *
 */
public class Gig {
	public final String stage;
	public Date date = null;
	
	public Gig(String stage, String date) {
		this.stage = stage;
		try {
			this.date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	
}
