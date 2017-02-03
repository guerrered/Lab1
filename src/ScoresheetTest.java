//CS361-401   2017
//Group Name: Hidden Bit

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ScoresheetTest {
	Scoresheet GDP;

//	Beginning of testing
	@BeforeClass
	public static void setupclass()
	{
		System.out.println("Tests stated");
	}
	
	@Before
	public void setup()
	{
		GDP=new Scoresheet();
		
	}
		@Before
		public void before(){
			GDP.clear();
		}
//		testOneThrow - test a single throw and check scoring for the first frame and game
		@Test
		public void testOneThrow(){
			GDP.Throw(7);
			//score for frame 0
			assertEquals(7,GDP.getFrame(0).getTotal());
			//total game score
			assertEquals(7,GDP.getTotalScore());
		}
		
//		testTwoThrows - test two throws and check scoring for the first frame and game
		@Test
		public void testTwoThrows(){
			GDP.Throw(7);
			GDP.Throw(2);
			//score for frame 0
			assertEquals(9,GDP.getFrame(0).getTotal());
			//total game score
			assertEquals(9,GDP.getTotalScore());
			
		}
		
//		testThreeThrows - test three throws and check scoring for the first two frames and
//		game
		@Test
		public void testThreeThrows(){
			GDP.Throw(7);
			GDP.Throw(2);
			GDP.Throw(9);
			//score for frame 0
			assertEquals(9, GDP.getFrame(0).getTotal());
			//score for frame 1
			assertEquals(9, GDP.getFrame(1).getTotal());
			//total game score
			assertEquals(18, GDP.getTotalScore());
			
		}
		
//		testSpareCountsNextFrameScore - throw a spare in a frame and make sure its
//		score is correct (counting the following frame, which should also be completed)
		@Test
		public void testSpareCountsNextFrameScore(){
			//Frame 0
			GDP.Throw(3);
			GDP.Throw(7);
			
			//Frame 1
			GDP.Throw(1);
			GDP.Throw(2);
			
			GDP.update();
			assertEquals(13, GDP.getFrame(0).getTotal());
			assertEquals(16, GDP.getTotalScore());
		}
		
//		testStrikeMovesToNextFrame - ensure that a strike frame may not have two
//		throws
		@Test
		public void testStrikeMovesToNextFrame(){
			int cur = GDP.getCurrentFrameIndex();
			GDP.Throw(10);
			GDP.Throw(2);
			assertEquals(cur + 1,GDP.getCurrentFrameIndex());
		}
		
//		testStrikeCountsNextFrameScores - throw a strike in a frame and make sure its
//		score is correct (counting the following frames, which should also be completed)
		@Test
		public void testStrikeCountsNextFrameScores(){
			//throw strike
			GDP.Throw(10);
			
			//frame 1
			GDP.Throw(4);
			GDP.Throw(4);
			
			//frame 2
			GDP.Throw(6);
			GDP.Throw(1);
			GDP.update();
			assertEquals(25, GDP.getFrame(0).getTotal());
			assertEquals(40, GDP.getTotalScore());
			
		}
		
//		testSpareOnLastFrame - test throwing a spare on the 10th frame
		@Test
		public void testSpareOnLastFrame(){
			for(int i = 0; i<18; i++){
				GDP.Throw(2);
			}
			GDP.Throw(9);
			GDP.Throw(1);
			assertEquals(10, GDP.getFrame(9).getTotal());
			assertEquals(46, GDP.getTotalScore());
		}
		
		
		
//		testStrikeOnLastFrames - test throwing a strike on the 8th, 9th, and 10th frames
		@Test
		public void testStrikeOnLastFrames(){
			for(int i = 0; i<14; i++){
				GDP.Throw(2);
			}
			GDP.Throw(10);
			GDP.Throw(10);
			GDP.Throw(10);
			GDP.update();
			assertEquals(30, GDP.getFrame(7).getTotal());
			assertEquals(20, GDP.getFrame(8).getTotal());
			assertEquals(10, GDP.getFrame(9).getTotal());
		}
//      testPerferctGame - test if all throw are strikes, max points is 270 pts		
		@Test
		public void testPerferctGame(){
			int i = 0;
			while(i < 10){
				GDP.Throw(10);
				i++;
			}
			GDP.update();
			assertEquals(270, GDP.getTotalScore());
		}
		
//		testThrowOn11thFrame - ensure throwing on the 11th frame is not allowed (in
//		some form)
		@Test(expected = IllegalArgumentException.class)
		public void testThrowOn11thFrame(){
			for(int i = 0; i<=21; i++){
				GDP.Throw(2);
			}
		}
	
//      testStrikeSpaceGame - test points after a strike and space		
		@Test
		public void testStrikeSpaceGame()
		{
			GDP.Throw(10);
			GDP.Throw(4);
			GDP.Throw(6);
			GDP.Throw(3);
			GDP.Throw(4);
			GDP.update();
			assertEquals(27, GDP.getFrame(0).getTotal());
			assertEquals(17, GDP.getFrame(1).getTotal());
		}
		
//      testStrikeZeroThrow - test zero after strike.		
		@Test
		public void testStrikeZeroThrow()
		{
			GDP.Throw(10);
			GDP.Throw(0);
			GDP.Throw(0);
			GDP.Throw(3);
			GDP.Throw(4);
			GDP.update();
			assertEquals(17, GDP.getFrame(0).getTotal());
			assertEquals(0, GDP.getFrame(1).getTotal());
		}

//       End of the testing
		@AfterClass
		public static void tearDownClass()
		{
			System.out.println("Tests Ended");
			
		}
		
		
	}

