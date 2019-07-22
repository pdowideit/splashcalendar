package splashcalendar;

import java.util.List;

import net.fortuna.ical4j.model.Calendar;

/**
 * Static class that holds all data
 * Runtime variables and final setting variables
 * @author Paul Dowideit (paul.dowideit@mat-traffic.de)
 *
 */
public class Data {
	// runtime
	/**
	 * Splash lineup
	 */
	public static List<Artist> lineup;
	
	/**
	 * Splash calendar
	 */
	public static Calendar calendar;
	
	
	// final settings
	/**
	 * Main URL of splash website
	 */
	public static final String splash_main_url = "https://splash-festival.de/de/";
	
	public static final String out_path = "D:\\DEV\\Paul\\eclipse-workspace\\splashcalendar\\out\\splashcal.ics";
	
	public static final String compare_path = "D:\\DEV\\Paul\\eclipse-workspace\\splashcalendar\\out\\splashcalendar.ics";
	
}
