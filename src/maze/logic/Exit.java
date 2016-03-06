package maze.logic;

public class Exit {

	private int x;
	private int y;
	private boolean HeroOut;
	
	public Exit(int x,int y)
	{
		this.x=x;
		this.y=y;
		HeroOut=false;
	}
	//GET'S---------------------
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public boolean getExitState(){
		return HeroOut;
	}
	//SET'S-----------------
	public void setHeroOut(){
		HeroOut=true;
	}
	
	public static void main(String[] args) {
		
	}

}
