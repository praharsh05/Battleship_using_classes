
public class Battleship {
	//attributes
	private boolean sunk;//sunk or not
	private int health;//health of the ship
	private int size;//size of the ship
	
	
	//constructor
	public Battleship() {
		this.sunk=false;//default values
		this.health=2;
		this.size=2;
	}
	
	//methods
	public void setHealth() {
		this.health=this.size=2;//setting the health and size as 2	
	}
	public void hit() {//when hit
		this.health--;
//		this.size--;
		if(this.health==0) {
			sunk=true;
		}
	}
	public void setSunk(boolean b) {
		this.sunk=b;
	}
	public boolean getStatus() {
		return sunk;
	}
	
}
