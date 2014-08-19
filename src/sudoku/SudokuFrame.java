package sudoku;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SudokuFrame extends JFrame {
	private JPanel buttonsPanel;
	private JPanel sudokuPanel;
	public SudokuFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(800, 600));
		this.setTitle("Sudoku");
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("Game");
		JMenu game = new JMenu("New Game");
		JMenuItem sixBySixGame = new JMenuItem("6 x 6 Game");
		sixBySixGame.addActionListener(new NewGameListener(SudokuPuzzleType.SIXBYSIX, 30));
		JMenuItem nineByNineGame = new JMenuItem("9 x 9 Game");
		nineByNineGame.addActionListener(new NewGameListener(SudokuPuzzleType.NINEBYNINE, 26));
		JMenuItem twelveByTwelveGame = new JMenuItem("12 x 12 Game");
		nineByNineGame.addActionListener(new NewGameListener(SudokuPuzzleType.TWELVEBYTWELVE, 20));
		game.add(sixBySixGame);
		game.add(nineByNineGame);
		game.add(twelveByTwelveGame);
		file.add(game);
		menuBar.add(file);
		this.setJMenuBar(menuBar);
		JPanel windowPanel = new JPanel();
		windowPanel.setPreferredSize(new Dimension(800, 600));
		windowPanel.setLayout(new FlowLayout());
		sudokuPanel = new JPanel();
		buttonsPanel = new JPanel();
		buttonsPanel.setPreferredSize(new Dimension(100, 500));
		windowPanel.add(sudokuPanel);
		windowPanel.add(buttonsPanel);
		rebuildInterface(SudokuPuzzleType.NINEBYNINE, 26);
	}
	public void rebuildInterface(SudokuPuzzleType puzzleType, int fontSize){
		SudokuPuzzle generatedPuzzle = new SudokuGenerator().generateRandomSudoku(puzzleType);
		sudokuPanel.newSudokuPuzzle(generatedPuzzle);
		sudokuPanel.setFont(sudokuPanel.getFont().deriveFont(fontSize));
		buttonsPanel.removeAll();
		for(String value : generatedPuzzle.getValidValues()) {
			JButton b = new JButton(value);
			b.setPreferredSize(new Dimension(40,40));
			b.addActionListener(sudokuPanel.new NumActionListener());
			buttonsPanel.add(b);
		}
		sudokuPanel.repaint();
		buttonsPanel.revalidate();
		buttonsPanel.repaint();
	}
	private class NewGameListener implements ActionListener{
		private int fontSize;
		private SudokuPuzzleType puzzleType;
		public NewGameListener(SudokuPuzzleType puzzleType, int fontSize){
			this.puzzleType = puzzleType;
			this.fontSize = fontSize;
		}
		public void actionPerformed(ActionEvent e){
			rebuildInterface(puzzleType, fontSize);
		}
	} 
	public static void main(String[] args){
		SudokuFrame frame = new SudokuFrame();
		frame.setVisible(true);
	}
}
