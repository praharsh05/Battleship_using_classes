
public class LargeBattleship extends Battleship{
	private static int LargeShip=1;
	
	//constructor
	public LargeBattleship() {
		super();
		this.setHealthSize(3);
	}
	
	//getter
	public int getLargeShips() {
		return LargeShip;
	}
}