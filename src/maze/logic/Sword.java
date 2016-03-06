package maze.logic;

public class Sword {
	private int x;
	private int y;
	private boolean gotSword;
	
	public Sword(int x,int y){
		this.x=x;
		this.y=y;
		gotSword=false;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean getSwordState(){
		return gotSword;
	}
	
	public void pickSword(){
		gotSword=true;
	}
	
	public static void main(String[] args) {
		
	}

}
