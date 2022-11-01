
public class SmallBattleship extends Battleship{
	private static int SmallShip=3;//static variable of number of ships
	
	//constructor
	public SmallBattleship() {
		super();
		this.setHealthSize(1);//set health and size to 1
	}
	
	//getter
	public int getSmallShips() {
		return SmallShip;
	}
}
