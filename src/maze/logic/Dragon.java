package maze.logic;

public class Dragon {
	private int x;
	private int y;
	private boolean sleep;
	private boolean alive;
	
	public Dragon(int x,int y){
		this.x=x;
		this.y=y;
		sleep=false;
		alive=true;
	}
	//GET'S------------------------------
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public boolean getSleep(){
		return sleep;
	}
	public boolean getLifeState(){
		return alive;
	}
	//SET'S-----------------------------
	public void setSleep(boolean s){
		sleep = s;
	}
	public void setDragonLife(){
		alive=false;
	}
	//-----------------------------------
	public void move(char direcao){
		if (direcao == 'a')
			y--;
		if (direcao == 's')
			x++;
		if (direcao == 'd')
			y++;
		if (direcao == 'w')
			x--;
	}
	public static void main(String[] args) {
		
	}

}
