package splashcalendar;

import net.fortuna.ical4j.model.Calendar;

public class CalendarComparator {
	public static boolean compare(Calendar cal1, Calendar cal2) {
		return cal1.equals(cal2);
	}
}
