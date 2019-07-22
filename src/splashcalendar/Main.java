package splashcalendar;

import java.io.FileOutputStream;
import java.io.IOException;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.validate.ValidationException;

public class Main {

	public static void main(String[] args) {
		Data.lineup = DataParser.parseLineup(Data.splash_main_url);
		
		Data.lineup = DataParser.parseGigs(Data.lineup);
		
		Data.calendar = CalendarGenerator.generate(Data.lineup);
		
		try {
			FileOutputStream fout = new FileOutputStream(Data.out_path);
	
			CalendarOutputter outputter = new CalendarOutputter();
	
			
				outputter.output(Data.calendar, fout);
		} catch (net.fortuna.ical4j.validate.ValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar calendar = null;
		try {
			Calendar cal = CalendarReader.readFromFile(Data.compare_path);
			
			calendar = cal;
		} catch (ValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean compare = CalendarComparator.compare(calendar, Data.calendar);
		
		if(compare)
			System.out.println("no calendar changes detected");
		
		if(!compare)
			System.out.println("calendar changes detected");
		
		
		
	}

}
