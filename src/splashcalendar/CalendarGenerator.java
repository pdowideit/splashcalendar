package splashcalendar;

import java.util.List;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.*;


public class CalendarGenerator {
	public static Calendar generate(List<Artist> artists) {
				
		Calendar calendar = new Calendar();
		calendar.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
		calendar.getProperties().add(Version.VERSION_2_0);
		calendar.getProperties().add(CalScale.GREGORIAN);
		
		for(Artist a : artists) {
			DateTime sdt = new DateTime(a.gig.date);
			
			java.util.Calendar c = java.util.Calendar.getInstance(); 
			c.setTime(a.gig.date); 
			c.add(java.util.Calendar.HOUR, 1);
			java.util.Date end = c.getTime();
			
			DateTime edt = new DateTime(end);
			 
			VEvent event = new VEvent(sdt, edt,a.name);
			event.getProperties().add(new Uid());
			event.getProperties().add(new Location(a.gig.stage));
			
			calendar.getComponents().add(event);
		}
		
		
		
		return calendar;

	}
}
