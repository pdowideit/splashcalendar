package splashcalendar;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.omg.CORBA.Environment;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.validate.ValidationException;

public class CalendarReader {
	public static Calendar readFromFile(String path) throws IOException, ValidationException{
		FileOutputStream fout = null;
		Calendar cal = new Calendar();
        try {
            fout = new FileOutputStream(path);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        CalendarOutputter outputter;
        try {
            outputter = new CalendarOutputter();
            outputter.output(cal, fout);
            return cal;
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        } catch (ValidationException e) {
            e.printStackTrace();
            throw new ValidationException();
        }
	}
}
