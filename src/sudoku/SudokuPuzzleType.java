package sudoku;

public enum SudokuPuzzleType {
	SIXBYSIX(6, 6, 3, 2, new String[] {"1", "2", "3", "4", "5", "6"}, "6 X 6 Game"),
	NINEBYNINE(9, 9, 3, 3, new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}, "9 X 9 Game"),
	TWELVEBYTWELVE(12, 12, 4, 3, new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C"}, "12 X 12 Game");
	
	private int rows;
	private int columns;
	private int boxWidth;
	private int boxHeight;
	private String[] validValues;
	private String puzzleType;
	
	public void SudokuPuzzleType(int rows, int columns, int boxWidth, int boxHeight, String[] validValues, String puzzleType){
		this.rows = rows;
		this.columns = columns;
		this.boxWidth = boxWidth;
		this.boxHeight = boxHeight;
		this.validValues = validValues;
		this.puzzleType = puzzleType;
	}
	public int getRows(){
		return rows;
	}
	public int getColumns(){
		return columns;
	}
	public int getBoxWidth(){
		return boxWidth;
	}
	public int getBoxHeight(){
		return boxHeight;
	}
	public String[] getValidValues(){
		return validValues;
	}
	public String getPuzzleType(){
		return puzzleType;
	}
}
