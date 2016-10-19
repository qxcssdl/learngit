package myLifeGame;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import myLifeGame.World.Status;

public class WorldTest {

	private World tmpWorld = new World(20, 20);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass()...");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("teatAfterClass()...");
	}

	@Test
	public void testRun() {
		
		System.out.println("testRun()...");
	}

	@Test
	public void testWorld() {
		for(int i = 0; i < 20; i++)
			for(int j = 0; j < 20; j++){
				tmpWorld.currentGeneration[i][j] = Status.Dead;
				assertSame(tmpWorld.currentGeneration,tmpWorld.currentGeneration);
			}
				
			
			
		System.out.println("testWorld()...");
	}

	@Test
	public void testPaintComponentGraphics() {
		System.out.println("testPaintComponentGraphics()...");
	}

}
