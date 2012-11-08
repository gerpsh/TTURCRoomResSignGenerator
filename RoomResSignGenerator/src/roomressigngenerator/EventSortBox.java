/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomressigngenerator;

import java.util.ArrayList;
import java.util.Date;

public class EventSortBox
{
	private ArrayList<CalendarEvent> box = new ArrayList<>();
	
	public void putEvent(CalendarEvent event)
	{
		box.add(event);
	}
	
	public CalendarEvent[] sortEvents()
	{
		CalendarEvent[] out = box.toArray(new CalendarEvent[box.size()]);
		for (int i = 0; i < (out.length) - 1; i++)
		{
			for (int j = 0; j < (out.length) - 1; j++)
			{
				CalendarEvent uno = out[j];
				CalendarEvent dos = out[j + 1];
				Date one = uno.getStartTime();
				Date two = dos.getStartTime();
				
				if(one.compareTo(two)>0)
				{
					out[j] = dos;
					out[j + 1] = uno;
				}
			}
		}
		return out;
	}
				
	
	public ArrayList<CalendarEvent> cloneBox()
	{
		return box;
	}
}
