/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomressigngenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class RoomResTable
{
	private ArrayList<TableRow> rows = new ArrayList<TableRow>();
	private ArrayList<TableRow> mondayRows = new ArrayList<TableRow>();
	private ArrayList<TableRow> tuesdayRows = new ArrayList<TableRow>();
	private ArrayList<TableRow> wednesdayRows = new ArrayList<TableRow>();
	private ArrayList<TableRow> thursdayRows = new ArrayList<TableRow>();
	private ArrayList<TableRow> fridayRows = new ArrayList<TableRow>();
	
	private String title;
	
	public RoomResTable()
	{
		title = "";
	}
	
	public RoomResTable(String titler)
	{
		title = titler;
	}
	
	public void setTitle(String titler)
	{
		title = titler;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void addRow(TableRow row)
	{
		rows.add(row);
	}
	
/*	public void fileRows()
	{
		for(TableRow row : rows)
		{
			System.out.println(row.getDay().getText());
			if (row.getDay().getText().equals("Monday"))
			{
				mondayRows.add(row);
			}
			else if (row.getDay().getText().equals("Tuesday"))
			{
				tuesdayRows.add(row);
			}
			else if (row.getDay().getText().equals("Wednesday"))
			{
				wednesdayRows.add(row);
			}
			else if (row.getDay().getText().equals("Thursday"))
			{
				thursdayRows.add(row);
			}
			else if (row.getDay().getText().equals("Friday"))
			{
				fridayRows.add(row);
			}
		}
*/

	public void fileRows()
	{
		for(int i = 0; i < rows.size(); i++)
		{
			TableRow row = rows.get(i);
			if((row.getDay().getText()).equals("Monday"))
			{
				mondayRows.add(row);
			}
			else if((row.getDay().getText()).equals("Tuesday"))
			{
				tuesdayRows.add(row);
			}
			else if((row.getDay().getText()).equals("Wednesday"))
			{
				wednesdayRows.add(row);
			}
			else if((row.getDay().getText()).equals("Thursday"))
			{
				thursdayRows.add(row);
			}
			else if((row.getDay().getText()).equals("Friday"))
			{
				fridayRows.add(row);
			}
		}
	}
	
	public void toHtml(String filePath) throws FileNotFoundException
	{
		File outFile = new File(filePath);
		PrintWriter out = new PrintWriter(outFile);
		boolean skips = false;
		if ((rows.size() < 12))
		{
			skips = true;
		}
		
		out.print("<html>\n<title>" + title + "</title>\n");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + title + "</h1>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Day</th>\n<th>Date</th>\n<th>Time</th>\n<th>Study</th>\n<th>Contact</th>\n");
		out.println("</tr>");
		if((mondayRows.size() != 0))
		{
			for(TableRow row : mondayRows)
			{
				out.println("<tr>");
				out.print("<td>");
				out.print(row.getDay().getText());
				out.println("</td>");
				out.print("<td>");
				out.print(row.getDate().getText());
				out.println("</td>");
				out.print("<td>");
				out.print(row.getTime().getText());
				out.println("</td>");
				if(row.getStudy().hasBgCol())
				{
					out.print("<td bgcolor = \"" + row.getStudy().getBgCol() + "\">");
					out.print(row.getStudy().getText());
					out.println("</td>");
				}
				else
				{
					out.print("<td>");
					out.print(row.getStudy().getText());
					out.println("</td>");
				}
					
				out.print("<td>");
				out.print(row.getContact().getText());
				out.println("</td>");
				out.println("</tr>");
			}
			if(skips)
			{
				out.println("<tr><td>&nbsp;</td>\n<td>&nbsp;</td>\n<td>&nbsp;</td>\n<td>&nbsp;</td>\n<td>&nbsp;</td>\n</tr>");
			}
		}
		
		if((tuesdayRows.size() != 0))
		{
			for(TableRow row : tuesdayRows)
			{
				out.println("<tr>");
				out.print("<td>");
				out.print(row.getDay().getText());
				out.println("</td>");
				out.print("<td>");
				out.print(row.getDate().getText());
				out.println("</td>");
				out.print("<td>");
				out.print(row.getTime().getText());
				out.println("</td>");
				if(row.getStudy().hasBgCol())
				{
					out.print("<td bgcolor = \"" + row.getStudy().getBgCol() + "\">");
					out.print(row.getStudy().getText());
					out.println("</td>");
				}
				else
				{
					out.print("<td>");
					out.print(row.getStudy().getText());
					out.println("</td>");
				}
					
				out.print("<td>");
				out.print(row.getContact().getText());
				out.println("</td>");
				out.println("</tr>");
			}
			if(skips)
			{
				out.println("<tr><td>&nbsp;</td>\n<td>&nbsp;</td>\n<td>&nbsp;</td>\n<td>&nbsp;</td>\n<td>&nbsp;</td>\n</tr>");
			}
		}
		
		if((wednesdayRows.size() != 0))
		{
			for(TableRow row : wednesdayRows)
			{
				out.println("<tr>");
				out.print("<td>");
				out.print(row.getDay().getText());
				out.println("</td>");
				out.print("<td>");
				out.print(row.getDate().getText());
				out.println("</td>");
				out.print("<td>");
				out.print(row.getTime().getText());
				out.println("</td>");
				if(row.getStudy().hasBgCol())
				{
					out.print("<td bgcolor = \"" + row.getStudy().getBgCol() + "\">");
					out.print(row.getStudy().getText());
					out.println("</td>");
				}
				else
				{
					out.print("<td>");
					out.print(row.getStudy().getText());
					out.println("</td>");
				}
					
				out.print("<td>");
				out.print(row.getContact().getText());
				out.println("</td>");
				out.println("</tr>");
			}
			if(skips)
			{
				out.println("<tr><td>&nbsp;</td>\n<td>&nbsp;</td>\n<td>&nbsp;</td>\n<td>&nbsp;</td>\n<td>&nbsp;</td>\n</tr>");
			}
		}
		
		if((thursdayRows.size() != 0))
		{
			for(TableRow row : thursdayRows)
			{
				out.println("<tr>");
				out.print("<td>");
				out.print(row.getDay().getText());
				out.println("</td>");
				out.print("<td>");
				out.print(row.getDate().getText());
				out.println("</td>");
				out.print("<td>");
				out.print(row.getTime().getText());
				out.println("</td>");
				if(row.getStudy().hasBgCol())
				{
					out.print("<td bgcolor = \"" + row.getStudy().getBgCol() + "\">");
					out.print(row.getStudy().getText());
					out.println("</td>");
				}
				else
				{
					out.print("<td>");
					out.print(row.getStudy().getText());
					out.println("</td>");
				}
					
				out.print("<td>");
				out.print(row.getContact().getText());
				out.println("</td>");
				out.println("</tr>");
			}
			if(skips)
			{
				out.println("<tr><td>&nbsp;</td>\n<td>&nbsp;</td>\n<td>&nbsp;</td>\n<td>&nbsp;</td>\n<td>&nbsp;</td>\n</tr>");
			}
		}
		if((fridayRows.size() != 0))
		{
			for(TableRow row : fridayRows)
			{
				out.println("<tr>");
				out.print("<td>");
				out.print(row.getDay().getText());
				out.println("</td>");
				out.print("<td>");
				out.print(row.getDate().getText());
				out.println("</td>");
				out.print("<td>");
				out.print(row.getTime().getText());
				out.println("</td>");
				if(row.getStudy().hasBgCol())
				{
					out.print("<td bgcolor = \"" + row.getStudy().getBgCol() + "\">");
					out.print(row.getStudy().getText());
					out.println("</td>");
				}
				else
				{
					out.print("<td>");
					out.print(row.getStudy().getText());
					out.println("</td>");
				}
					
				out.print("<td>");
				out.print(row.getContact().getText());
				out.println("</td>");
				out.println("</tr>");
			}
		}
		int diff;
		if (!(skips))
		{
			diff = 18 - rows.size();
		}
		else
		{
			diff = 14 - rows.size();
		}
		
		if (diff > 0)
		{
			for(int i = 0; i < diff; i++)
			{
				out.println("<tr><td>&nbsp;</td>\n<td>&nbsp;</td>\n<td>&nbsp;</td>\n<td>&nbsp;</td>\n<td>&nbsp;</td>\n</tr>");
			}
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
					
		out.close();
		
	}
}