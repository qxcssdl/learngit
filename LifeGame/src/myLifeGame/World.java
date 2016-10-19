package myLifeGame;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class World extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int rows;
	private final int columns;
	
	static enum Status {
		Alive,
		Dead;
	};
	
	public Status[][] currentGeneration;
	public  Status[][] nextGeneration;
	private volatile boolean isChanging;
	
	World(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		currentGeneration = new Status[rows][columns];
		Random rand = new Random();
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(rand.nextBoolean()) {
					currentGeneration[i][j] = Status.Alive;
				}
				else {
					currentGeneration[i][j] = Status.Dead;
				}
			}
		}
		
		nextGeneration = new Status[rows][columns];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				nextGeneration[i][j] = Status.Dead;
			}
		}
		
	}

	public void run() {
		while(true)
		{
			isChanging = false;
			
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < this.columns; j++) {
					changeStatus(i, j);
				}
			}
			
			Status[][] temp = currentGeneration;
			currentGeneration = nextGeneration;
			nextGeneration = temp;
			
			for(int i = 0; i < rows && !isChanging; i++) {
				for(int j = 0; j < columns; j++) {
					if(nextGeneration[i][j] != currentGeneration[i][j]) {
						isChanging = true;
						break;
					}
				}
			}
			
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < columns; j++) {
					nextGeneration[i][j] = Status.Dead;
				}
			}
			
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void changeStatus(int i, int j) {
		int alive = 0;
		
		if(i > 0 && j > 0 && currentGeneration[i - 1][j - 1] == Status.Alive) alive++;
		if(j > 0 && currentGeneration[i][j - 1] == Status.Alive) alive++;
		if(j < this.columns - 1 && currentGeneration[i][j + 1] == Status.Alive) alive++;
		if(i > 0 && currentGeneration[i - 1][j] == Status.Alive) alive++;
		if(i < this.rows - 1 && currentGeneration[i + 1][j] == Status.Alive) alive++;
		if(i > 0 && j < this.columns - 1 && currentGeneration[i - 1][j + 1] == Status.Alive) alive++;
		if(j < this.columns - 1 && currentGeneration[i][j + 1] == Status.Alive) alive++;
		if(i < this.rows - 1 && j < this.columns - 1 && currentGeneration[i + 1][j + 1] == Status.Alive) alive++;
		
		if(alive == 2) nextGeneration[i][j] = currentGeneration[i][j];
		else if(alive == 3) nextGeneration[i][j] = Status.Alive;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(currentGeneration[i][j] == Status.Alive) {
					g.fillRect(j * 20, i * 20, 20, 20);
				}
				else {
					g.drawRect(j * 20, i * 20, 20, 20);
				}
			}
		}
	}
	
}
