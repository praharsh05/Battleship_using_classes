
public class MediumBattleship extends Battleship{
	private static int MediumShip=2;//static variable of number of ships
	
	//constructor
	public MediumBattleship() {
		super();
		this.setHealthSize(2);
	}
		
	//getter
	public int getMediumShips() {
		return MediumShip;
	}	
}
