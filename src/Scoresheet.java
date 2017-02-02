
public class Scoresheet {

int scores=0;
int Score[];
//ind 1,2 for throw 1,2. ind3 for score in that frame
boolean Strike=false;
int ThrowNum=0;
int Frame;
int frameCheck =0;
	
public Scoresheet()
{
	Score= new int[30];
	
}
	
//throw method that record points to scores sheet
public int Throw(int cnt)
{
	if(Frame>10) throw new IllegalArgumentException();
	//gotta check if there is not strike 2 throw points have to less than 10;
	assert _wellFormed() : "Linked collection well-formed at end of constructor";
	
	Score[ThrowNum]=cnt;
	incremenetThrow();
	
	return cnt;
}


//Check whether One frame has been completed
public void incremenetThrow(){
	ThrowNum++;
	frameCheck++;
	if(frameCheck == 2){
		ThrowNum++;
		Frame++;
		frameCheck = 0;
	}
}

public int getScore()
{   int cnt=0;
	
	
	return cnt;
}

public int getFrame()
{
	return Frame;
}

//Check whether the 10 frame has complete

 private boolean _wellFormed() {
	if() return report("");
	
	return true;
}



private boolean report(String error) {
	System.out.println("Invariant error found: " + error);
	return false;
}

//reset
public void clear()
{
	scores=0;
	Score= new int[30];
	ThrowNum=0;
	Frame=0;
}

	
	
	
	
}
