import java.lang.reflect.Array;

public class Scoresheet {

int totalScore = 0;
Frame Score[];
int throwNum = 1;
int frameIndex;

public Scoresheet()
{
	Score= new Frame[10];
	frameIndex = 0;
}
	
//throw method that record points to scores sheet
public void Throw(int cnt)
{
	if(frameIndex>10||cnt>10) throw new IllegalArgumentException();
	//gotta check if there is not strike 2 throw points have to less than 10;
	//assert _wellFormed() : "Throw at the beginning";
	
	if(throwNum == 1){
		Score[frameIndex].firstThrow(cnt);
		throwNum++;//next throw
	}
	else{
		if(!Score[frameIndex].isStrike()){//can't do second throw if strike
			Score[frameIndex].secondThrow(cnt);
		}
		throwNum--;//brings back to first throw
		frameIndex++;//go to next frame
	}
}

//update score for strikes and spares
public void update()
{
	int i = 0;
	while((i + 2) < frameIndex){//can only update two spots above a strike 
		if(Score[i].isStrike()){//if i > 8 it'll be outofBounds
			if(i > 8){
				Score[i].addtoTotal(Score[i + 1].getTotal());
			}
			else{
				Score[i].addtoTotal(Score[i+1].getTotal() + Score[i + 2].getTotal());
			}
		}
		if(Score[i].isSpare()){
			Score[i].addtoTotal(Score[i +1].getTotal());
		}
		i++;
	}
}

//score for certain frame
public int getTotalScore()
{   
	int i = 0; 
	int tempTotal = 0;
	while( i < frameIndex){//can only get total up to current frame
		tempTotal += Score[i].getTotal();
		i++;
	}
	totalScore = tempTotal;
	return totalScore;
}

public Frame getFrame(int index)
{
	return Score[index];
}


// private boolean _wellFormed() {
//	if() return report("");
//	
//	return true;
//}



private boolean report(String error) {
	System.out.println("Invariant error found: " + error);
	return false;
}

//reset
public void clear()
{
	totalScore=0;
	Score= new Frame[10];
	throwNum=1;
	frameIndex=0;
}

	
	
	
	
}
