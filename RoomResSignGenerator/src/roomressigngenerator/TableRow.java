package roomressigngenerator;

//import TableCell;


public class TableRow
{
	private TableCell[] cells = new TableCell[5];
	/*0 = Day
	  1 = Date
	  2 = Time
	  3 = Study
	  4 = Contact
	*/
	public TableRow() {
		cells[0] = new TableCell("");
		cells[1] = new TableCell("");
		cells[2] = new TableCell("");
		cells[3] = new TableCell("");
		cells[4] = new TableCell("");
	}
	
	public void setDay(TableCell day) {
		cells[0] = day;
	}
	
	public void setDate(TableCell date) {
		cells[1] = date;
	}
	
	public void setTime(TableCell time) {
		cells[2] = time;
	}
	
	public void setStudy(TableCell study) {
		cells[3] = study;
	}
	
	public void setContact(TableCell contact) {
		cells[4] = contact;
	}
	
	public TableCell getDay() {
		if(cells[0] != null) {
			return cells[0];
		}
		else {
			return null;
		}
	}
	
	public TableCell getDate() {
		if(cells[1] != null) {
			return cells[1];
		}
		else {
			return null;
		}
	}
	
	public TableCell getTime() {
		if(cells[2] != null) {
			return cells[2];
		}
		else {
			return null;
		}
	}
	
	public TableCell getStudy() {
		if(cells[3] != null) {
			return cells[3];
		}
		else {
			return null;
		}
	}
	
	public TableCell getContact() {
		if(cells[4] != null) {
			return cells[4];
		}
		else {
			return null;
		}
	}
	
	public TableCell[] cloneCellsForIter() {
		TableCell[] cellsy = new TableCell[5];
		cellsy = cells;
		return cellsy;
	}			
}