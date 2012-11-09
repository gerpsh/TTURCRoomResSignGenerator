package roomressigngenerator;

public class TableCell
{
	private String text;
	private String bgCol;

	
	public TableCell() {
		bgCol = "";
	}
	
	public TableCell(String txt) {
		text = txt;
		bgCol = "";
	}
	
	public void setText(String txt) {
		text = txt;
	}
	
	public void setBgCol(String col) {
		bgCol = col;
	}
	
	public String getText() {
		return text;
	}
	
	public boolean hasBgCol() {
		if(bgCol != "") {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getBgCol() {
		return bgCol;
	}			
}