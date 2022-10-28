
public class Battleship {
	//attributes
	protected boolean sunk;//sunk or not
	protected int health;//health of the ship
	protected int size;//size of the ship
	
	
	//constructor
	public Battleship() {
		this.sunk=false;//default values
		this.health=2;
		this.size=2;
	}
	
	//methods
	public void setHealthSize(int a) {
		this.health=a;
		this.size=a;
	}
	public void hit() {//when a ship is hit
		this.health--;
		if(this.health==0) {//if health becomes 0 then ship is sunk
			sunk=true;
		}
	}
	public void setSunk(boolean b) {//setting the boolean 
		this.sunk=b;
	}
	public boolean getStatus() {//getting the status of ship if sunk or not
		return sunk;
	}
	
}
