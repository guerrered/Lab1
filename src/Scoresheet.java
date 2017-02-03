//CS361-401   2017
//Group Name: Hidden Bit

public class Scoresheet {

int totalScore = 0;
Frame Score[];
int throwNum ;
int frameIndex;

public Scoresheet()
{
	Score= new Frame[10];
	frameIndex = 0;
	throwNum=1;
}
	
//throw method that record points to scores sheet
public void Throw(int cnt)
{
	if(frameIndex>9||cnt>10) throw new IllegalArgumentException();
	//gotta check if there is not strike 2 throw points have to less than 10;
	//assert _wellFormed() : "Throw at the beginning";
	
	if(throwNum == 1){
		Score[frameIndex]=new Frame();
		Score[frameIndex].firstThrow(cnt);
		if(cnt==10){
				frameIndex++;
		}
		else{
			throwNum++;//next throw
		}
	}
	else{
		if(!Score[frameIndex].isStrike()){//can't do second throw if strike
			Score[frameIndex].secondThrow(cnt);
			//brings back to first throw
			throwNum--;
		}
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
	if(Score[i].isSpare() || (Score[i].isStrike() && i == 8)){//spare only adds next frame at frame 9 a strike acts like a spare
		Score[i].addtoTotal(Score[i +1].getTotal());
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
	if(throwNum == 2)tempTotal += Score[frameIndex].total;
	totalScore = tempTotal;
	return totalScore;
}

public Frame getFrame(int index)
{
	return Score[index];
}


public int getCurrentFrameIndex(){
	return frameIndex;
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
