package sudoku;

import SudokuPuzzle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class SudokuPanel extends JPanel{
	private SudokuPuzzle puzzle;
	private int selectedRow;
	private int selectedColumn;
	private int usedWidth;
	private int usedHeight;
	private int fontSize;
	public SudokuPanel(){
		this.setPreferredSize(new Dimension(540, 450));
		this.addMouseListener(new sudokuPanelMouseListener());
		this.puzzle = new SudokuGenerator().generateRandomSudoku(SudokuPuzzleType.NINEBYNINE);
		this.selectedRow = -1;
		this.selectedColumn = -1;
		fontSize = 26;
	}
	public SudokuPanel(SudokuPuzzle puzzle){
		this.setPreferredSize(new Dimension(540, 450));
		this.addMouseListener(new sudokuPanelMouseListener());
		this.puzzle = puzzle;
		this.selectedRow = -1;
		this.selectedColumn = -1;
		fontSize = 26;
	}
	public void newSudokuPuzzle(SudokuPuzzle puzzle) {
		this.puzzle = puzzle;
	}
	
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	protected void paintComponent(Graphics g){
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(1.0f,1.0f,1.0f));
		int slotWidth = this.getWidth()/puzzle.getNumColumns();
		int slotHeight = this.getHeight()/puzzle.getNumRows();
		usedWidth = (this.getWidth()/puzzle.getNumColumns())*puzzle.getNumColumns();
		usedHeight = (this.getHeight()/puzzle.getNumRows())*puzzle.getNumRows();
		g2d.fillRect(0, 0,usedWidth,usedHeight);
		g2d.setColor(new Color(0.0f,0.0f,0.0f));
	}
	
}
