
public class Frame {
	int throw1;
	int throw2;
	int total;
	boolean Strike = false;
	boolean Spare = false;
	
	public void firstThrow(int score){
		if(score > 10 || score < 0){
			throw new IllegalArgumentException();
		}
		if(score == 10){
			throw1 = score;
			setStrike();
		}
		total = throw1;
	}
	
	public void secondThrow(int score){
		if((score > 10 - throw1) || score < 0){
			throw new IllegalArgumentException();
		}
		throw2 = score;
		if(throw1 + throw2 == 10){
			setSpare();
		}
		total += throw2;
	}
	
	public void setStrike(){
		Strike = true;
	}
	
	public void setSpare(){
		Spare = true;
	}
	
	public boolean isStrike(){
		return Strike;
	}
	
	public boolean isSpare(){
		return Spare;
	}
	
	public void setTotal(int tot){
		total = tot; 
	}
	
	public void addtoTotal(int extra){//adds extra points
		total += extra;
	}
	
	public int getTotal(){
		return total;
	}
}
