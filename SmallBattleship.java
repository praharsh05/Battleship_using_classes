
public class SmallBattleship extends Battleship{
	private static int SmallShip=3;
	
	//constructor
	public SmallBattleship() {
		super();
		this.setHealthSize(1);
	}
	
	//getter
	public int getSmallShips() {
		return SmallShip;
	}
}
