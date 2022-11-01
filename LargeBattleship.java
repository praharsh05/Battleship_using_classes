
public class LargeBattleship extends Battleship{
	private static int LargeShip=1;//static variable of number of ships
	
	//constructor
	public LargeBattleship() {
		super();
		this.setHealthSize(3);//set health and size to 3
	}
	
	//getter
	public int getLargeShips() {
		return LargeShip;
	}
}
