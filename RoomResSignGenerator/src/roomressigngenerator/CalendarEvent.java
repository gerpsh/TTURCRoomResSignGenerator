/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomressigngenerator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class CalendarEvent
{
	private String eventDay;
	private Date startTime;
	private Date endTime;
	private String studyName;
	private String eventContact;
	private HashMap<String, String> snc = new HashMap<>();
	private HashMap<String, String> colors = new HashMap<>();
	
	
	public CalendarEvent() {
		snc.put("DPL", "Jocelyn");
		snc.put("PAS", "Jocelyn");
		snc.put("MRQ", "Leah");
		snc.put("CRT", "Dominique");
		snc.put("GAL", "Becky");
		snc.put("CTA", "Becky");
		snc.put("GAK", "Becky");
		snc.put("TFM", "Patricia");
                snc.put("HVT", "Patricia");
		
		colors.put("DPL", "Teal");
		colors.put("PAS", "Violet");
		colors.put("MRQ", "ForestGreen");
		colors.put("CRT", "Yellow");
		colors.put("GAL", "Maroon");
		colors.put("CTA", "Aqua");
		colors.put("GAK", "Purple");
		colors.put("TFM", "Red");
                colors.put("HVT", "LightGrey");
	}
	
	public String getEventDay() {	
			return eventDay;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	
	public String getStudy() {
		return studyName;
	}
	
	public String getContact() {
		if(eventContact.equals(null)) {
			String contact = snc.get(studyName);
			if(contact.equals(null)) {
				return "";
			}
			else {
				return contact;
			}
		}
		else {
			return eventContact;
		}
	}
	
	public void setEventDay(String dey) {
		eventDay = dey;
	}
	
	public void setStartTime(Date start) {
		startTime = start;
	}
	
	public void setEndTime(Date end) {
		endTime = end;
	}
	
	public void setStudyName(String stud) {
		studyName = stud;
	}
	
	public void setEventContact(String cont) {
		eventContact = cont;
	}
	
	public void setEventContact() {
		eventContact = snc.get(studyName);
	}
	
	public TableRow toRow() {
		TableRow row = new TableRow();
	
		TableCell day = new TableCell(eventDay);
		TableCell date = new TableCell();
		TableCell time = new TableCell();
		TableCell study = new TableCell(studyName);
		if(colors.containsKey(studyName)) {
			study.setBgCol(colors.get(studyName));
		}
		TableCell contact = new TableCell(eventContact);
		
		row.setDay(day);
		row.setStudy(study);
		row.setContact(contact);
		
		Calendar eventDateCal = Calendar.getInstance();
		Calendar startTimeCal = Calendar.getInstance();
		Calendar endTimeCal = Calendar.getInstance();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		SimpleDateFormat timesFormat = new SimpleDateFormat("h:mma");
		
		String fullTime = timesFormat.format(startTime) + "-" + timesFormat.format(endTime);
		String stringDate = dateFormat.format(startTime);
		
		date.setText(stringDate);
		row.setDate(date);
		time.setText(fullTime);
		row.setTime(time);
		
		return row;
	}
}