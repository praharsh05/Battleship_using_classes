
public class Square {
	//attributes
	private int row;//row of the board
	private int coloumn;//column of the board
	private boolean occupancy;//occupancy of the square
	private boolean fire;//shots fired at the square
	
	//reference of battleship
	private Battleship bt=null;
	
	//constructor
	public Square(int a,int b) {
		setRow(a);
		setColoumn(b);
		setOccupancy(false);//default value of a cell
		setFired(false);//default value of a cell
	}
	//setters
	public void setRow(int a) {//setting row
		this.row=a;
	}
	public void setColoumn(int a) {//setting column
		this.coloumn=a;
	}
	public void setOccupancy(boolean b) {//setting occupancy
		this.occupancy=b;
	}
	public void setFired(boolean b) {//setting fire status
		this.fire=b;
	}
	public void setBattleship(Battleship ship) {//setting ship
		this.bt=ship;
	}
	//getters
	public int getRow() {//getting row
		return this.row;
	}
	public int getColoumn() {//getting column
		return this.coloumn;
	}
	public boolean getOccupancy() {//get occupancy
		return this.occupancy;
	}
	public boolean getFire() {//get fire status
		return this.fire;
	}
	public Battleship getBattleship() {//get ship
		return this.bt;
	}
	public String toString() {//display the changes on the board
		String hit="x";//in case of hit on the ship
		String miss="o";//in case of a miss
		String water="-";//in case there's no interaction with the cell
		if(this.getFire()==true) {//check if fired on the square
			if(this.getOccupancy()==true) {//check if a ship occupies the square
				return String.format("%3s", hit);//give 3 spaces in length
			}
			else return String.format("%3s",miss);//give 3 spaces in length
			}
			else return String.format("%3s",water);//give 3 spaces in length
	}
}

