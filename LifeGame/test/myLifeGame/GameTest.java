package myLifeGame;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class GameTest {

	
	private Game tmpGame = new Game();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass()...");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass()...");
	}

	@Test
	public void testGame() {
		
		assertTrue(!tmpGame.isMaximumSizeSet());
		assertTrue(!tmpGame.isMinimumSizeSet());
		System.out.println("testGame()...");
	}

	@Test
	public void testMain() {
		
		assertTrue(!tmpGame.isVisible());
		System.out.println("testMain()...");
	}

}
