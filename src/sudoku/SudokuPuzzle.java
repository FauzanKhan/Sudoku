package sudoku;

public class SudokuPuzzle {
	protected String[][] board;
	private int rows;
	private int columns;
	private int boxWidth;
	private int boxHeight;
	private String[] validValues;
	public SudokuPuzzle(int rows, int columns, int boxWidth, int boxHeight, String[] validValues){
		this.rows = rows;
		this.columns = columns;
		this.boxWidth = boxWidth;
		this.boxHeight = boxHeight;
		this.validValues = validValues;
	}
	public SudokuPuzzle(SudokuPuzzle puzzle){
		this.rows = puzzle.rows;
		this.columns = puzzle.columns;
		this.boxWidth = puzzle.boxWidth;
		this.boxHeight = puzzle.boxHeight;
		this.validValues = puzzle.validValues;
	}
	public int getNumRows(){
		return rows;
	}
	public int getNumColumns(){
		return columns;
	}
	public int getBoxHeight(){
		return boxHeight;
	}
	public int getBoxWidth(){
		return boxWidth;
	}
	public String[] validValues(){
		return validValues;
	}
	public void makeMove(int row, int col, String value){
		if(isValidValue(value) && isValidMove(row, col, value)){
			board[row][col] = value;
		}
	}
	public boolean isValidValue(String value){
		for(String s : validValues){
			if(s.equals(value))
				return true;
		}
		return false;
	}
	public boolean isValidMove(int row, int col, String value){
		if(inRange(row, col)){
			if(!isNumInCol(col, value) && !isNumInRow(row, value) && !isNumInBox(row, col, value))
				return true;
		}
		return false;
	}
	public boolean inRange(int row, int col){
		if(row <= rows && col <= columns)
			return true;
		return false;
	}
	public boolean isNumInCol(int col, String value){
		if(col <= columns){
			for(int i=0; i<=rows; i++){
				if(board[i][col].equals(value))
					return true;
			}
		}
		return false;
	}
	public boolean isNumInRow(int row, String value){
		if(row <= rows){
			for(int i=0;i<=columns;i++){
				if(board[row][i].equals(value))
					return true;
			}
		}
		return false;
	}
	public boolean isNumInBox(int row, int col, String value){
		if(inRange(row, col)){
			int boxRow = row/boxHeight;
			int boxCol = col/boxWidth;
			int startingRow = boxRow*boxHeight;
			int startingCol = boxCol*boxWidth;
			for(int i=0; i<startingRow+boxHeight;i++){
				for(int j=0; j<startingCol+boxWidth; j++){
					if(board[i][j].equals(value))
						return true;
				}
			}
		}
		return false;
	}
	public boolean isSlotEmpty(int row, int col){
		if(inRange(row, col)){
			if(board[row][col].equals(""))
				return true;
		}
		return false;
	}
	public String[][] getBoard(){
		return board;
	}
	public String getSlotValue(int row, int col){
		if(inRange(row, col)){
			return board[row][col];
		}
		return "";
	}
	public boolean isBoardFull(int row, int col){
		if(inRange(row, col)){
			for(int i=0; i<rows; i++){
				for(int j=0; j<columns; j++){
					if(board[i][j].equals(""))
						return false;
				}
			}
		}
		return true;
	}
	public void makeSlotEmpty(int row, int col){
		if(inRange(row, col)){
			board[row][col] = "";
		}
	}
	@Override
	public String toString() {
		String str = "Game Board:\n";
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				str += board[j][j] + " ";
			}
			str += "\n";
		}
		return str+"\n";
	}
	
	private void initializeBoard() {
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				board[i][j] = "";
			}
		}
	}
}
