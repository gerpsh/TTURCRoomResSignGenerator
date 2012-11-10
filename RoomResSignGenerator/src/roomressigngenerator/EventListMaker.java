package roomressigngenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventListMaker
{
	private EventSortBox sortBox = new EventSortBox();
	
	public EventListMaker() {
	
	}
	
	public CalendarEvent[] compileList(String urlString) throws Exception {
		
	
		URL output = new URL(urlString);
		BufferedReader in = new BufferedReader(new InputStreamReader(output.openStream()));
		StringBuffer str = new StringBuffer();
		String line = in.readLine();
		while(line != null) {
			str.append(line + "\n");
			//str.append("\n");
			line = in.readLine();
		}
		
		String fullString = str.toString();
		fullString = fullString.replace("\"", "");
		fullString = fullString.replace("}", "");
		fullString = fullString.replace("{", "");
		fullString = fullString.replace("]", "");
		fullString = fullString.replace("[", "");
		fullString = fullString.replace("when:", "");
		String[] eventsArr = fullString.split("kind:calendar#event");
		for(int i = 2; i < eventsArr.length; i++) {
			CalendarEvent event = new CalendarEvent();
			String eventString = eventsArr[i];
			String[] eventData = eventString.split(",");
			for(String eventDatum : eventData) {
				if(eventDatum.startsWith("title:")) {
					eventDatum = eventDatum.replace("title:", "");
					String study = eventDatum.substring(0, 3);
					event.setStudyName(study);
					event.setEventContact();
				}
				else if(eventDatum.startsWith("start:")) {
					eventDatum = eventDatum.replace("start:", "");
					eventDatum = eventDatum.replace(".000-4:00", "");

					SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
					SimpleDateFormat timeOutFormat = new SimpleDateFormat("h:mma");
					SimpleDateFormat dayOutFormat = new SimpleDateFormat("EEEE");
					
					
					Date startDate = inFormat.parse(eventDatum);
					
					event.setStartTime(startDate);
					event.setEventDay(dayOutFormat.format(startDate));
				}
				else if(eventDatum.startsWith("end:")) {
					eventDatum = eventDatum.replace("end:", "");
					eventDatum = eventDatum.replace(".000-4:00", "");
					SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
					SimpleDateFormat timeOutFormat = new SimpleDateFormat("h:mma");
					
					Date endTime = inFormat.parse(eventDatum);
					event.setEndTime(endTime);
				}
			}
			
			sortBox.putEvent(event);
		}
		
		CalendarEvent[] eventSet = sortBox.sortEvents();
		return eventSet;
	}
	
	public void printEvents(String url) throws Exception {
		URL output = new URL(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(output.openStream()));
		StringBuffer str = new StringBuffer();
		String line = in.readLine();
		while(line != null) {
			str.append(line);
			str.append("\n");
			line = in.readLine();
		}
		
		String fullString = str.toString();
		fullString = fullString.replace("\"", "");
		fullString = fullString.replace("}", "");
		fullString = fullString.replace("{", "");
		fullString = fullString.replace("]", "");
		fullString = fullString.replace("[", "");
		fullString = fullString.replace("when:", "");
		String[] eventsArr = fullString.split("kind:calendar#event");
		for(int i = 2; i < eventsArr.length; i++) {
			String eventString = eventsArr[i];
			String[] eventData = eventString.split(",");
			for(String eventDatum : eventData) {
				if(eventDatum.startsWith("title:")) {
					eventDatum = eventDatum.replace("title:", "");
					System.out.println(eventDatum);
				}
				else if(eventDatum.startsWith("start:")) {
					eventDatum = eventDatum.replace("start:", "");
					eventDatum = eventDatum.replace(".000-4:00", "");
				}
				else if(eventDatum.startsWith("end:")) {
					eventDatum = eventDatum.replace("end:", "");
					eventDatum = eventDatum.replace(".000-4:00", "");		
				}
			}
		}	
	}	
}
