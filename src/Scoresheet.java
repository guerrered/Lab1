
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
	
public int Throw(int cnt)
{
	Score[ThrowNum]=cnt;
	incremenetThrow();
	
	return cnt;
}

public void incremenetThrow(){
	ThrowNum++;
	frameCheck++;
	if(frameCheck == 2){
		ThrowNum++;
		frameCheck = 0;
	}
}

	


	
	
	
	
}
