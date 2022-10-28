
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
	public int getColoumn() {//getting coloumn
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
}

