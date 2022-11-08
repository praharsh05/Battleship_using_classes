/*
 * Name: Praharsh R Dubey
 * GUID: 2738037D
 */
public class MediumBattleship extends Battleship{
	private static int MediumShip=2;//static variable of number of ships
	
	//constructor
	public MediumBattleship() {
		super();
		this.setHealthSize(2);//set health and size to 2
	}
		
	//getter
	public int getMediumShips() {
		return MediumShip;
	}	
}
