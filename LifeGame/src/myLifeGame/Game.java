package myLifeGame;

import javax.swing.JFrame;

public class Game extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Game() {
		World world = new World(20, 20);
		new Thread(world).start();
		
		this.setSize(406, 428);
		this.setTitle("…˙√¸”Œœ∑");
		this.add(world);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.setVisible(true);
	}
}
