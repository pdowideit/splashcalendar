package splashcalendar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import splashcalendar.exceptions.NoGigInfoFoundException;
import splashcalendar.exceptions.NoLineUpFoundException;
/**
 * Static class containing all parsing methods
 * @author Paul Dowideit (paul.dowideit@mat-traffic.de)
 *
 */
public class DataParser {

	/**
	 * Parses lineup from url and returns it as List
	 * @param url URL containing lineup
	 * @return List of Artists
	 */
	public static List<Artist> parseLineup(String url){
		Element lineupList = null;
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			Elements lists = doc.select("ul");
			for(Element list : lists) {
				if(list.attr("class").equals("lineup__list")) {
					lineupList = list;
					break;
				}
			}
			if(lineupList == null) {
				throw new NoLineUpFoundException();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoLineUpFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Artist> artists = new ArrayList<Artist>();
		
		for(Element child : lineupList.children()) {
			Elements childChilden = child.children();
			String artistUrl = childChilden.get(0).attr("href");
			String name = child.text();
			if(!name.equals("Line Up"))
				artists.add(new Artist(name, artistUrl));
		}
		
		
		return artists;
	}
	
	
	public static List<Artist> parseGigs(List<Artist> artists){
		
		for(Artist a : artists) {
			Document doc;
			Element gigInfo = null;
			try {
				doc = Jsoup.connect(a.url).get();
				Elements asides = doc.select("aside");
				for(Element aside : asides) {
					if(aside.attr("class").equals("event__meta")) {
						gigInfo = aside;
						break;
					}
				}
				if(gigInfo == null)
					throw new NoGigInfoFoundException(a);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoGigInfoFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String date = "";
			String stage = "";
			for(Element child : gigInfo.children()) {
				if(child.attr("class").equals("event__meta--time"))
					date = child.text();

				if(child.attr("class").equals("event__meta--location"))
					stage = child.text();
			}
			
			int day = 0;
			String[] splitDate = date.split(", ");
			switch(splitDate[0]) {
				case "Wednesday":
					day = 10;
					break;
				case "Thursday":
					day = 11;
					break;
				case "Friday":
					day = 12;
					break;
				case "Saturday":
					day = 13;
					break;
			}
			if(Integer.parseInt(splitDate[1].split(":")[0]) < 12) {
				day++;
			}
			
			String correctFormatDate = day + "/07/2019 ";
			
			correctFormatDate += splitDate[1];
			
			a.gig = new Gig(stage, correctFormatDate);
		}
		
		
		return artists;
	}
	
	
	
}
