import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScoresheetTest {
	Scoresheet GDP;
	@Before
	public void setup()
	{
		GDP=new Scoresheet();
		
	}
		
//		testOneThrow - test a single throw and check scoring for the first frame and game
		@Test
		public void testOneThrow(){
			GDP.Throw(7);
			assertEquals(7,GDP.getScore());
		}
		
//		testTwoThrows - test two throws and check scoring for the first frame and game
		@Test
		public void testTwoThrows(){
			GDP.Throw(7);
			GDP.Throw(2);
			assertEquals(9,GDP.getScore());
		}
		
//		testThreeThrows - test three throws and check scoring for the first two frames and
//		game
		@Test
		public void testThreeThrows(){
			
		}
		
//		testSpareCountsNextFrameScore - throw a spare in a frame and make sure its
//		score is correct (counting the following frame, which should also be completed)
		@Test
		public void testSpareCountsNextFrameScore(){
			
		}
		
//		testStrikeMovesToNextFrame - ensure that a strike frame may not have two
//		throws
		@Test
		public void testStrikeMovesToNextFrame(){
			
		}
		
//		testStrikeCountsNextFrameScores - throw a strike in a frame and make sure its
//		score is correct (counting the following frames, which should also be completed)
		@Test
		public void testStrikeCountsNextFrameScores(){
			
		}
		
//		testSpareOnLastFrame - test throwing a spare on the 10th frame
		@Test
		public void testSpareOnLastFrame(){
			
		}
		
//		testStrikeOnLastFrames - test throwing a strike on the 8th, 9th, and 10th frames
		@Test
		public void testStrikeOnLastFrames(){
			
		}
		
//		testThrowOn11thFrame - ensure throwing on the 11th frame is not allowed (in
//		some form)
		@Test
		public void testThrowOn11thFrame(){
			
		}
	}

