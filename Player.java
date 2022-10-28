import java.util.Scanner;
public class Player {
	//attributes
	private String name;//name
	private int score;//score
	
	//constructor
	public Player(String n) {
		this.name=n;
		this.score=0;//default value
	}
	
	//methods
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public boolean takeTurn(BSBoard b) {
		Square[][] sq=b.getBoard();//get the current board
		Scanner s=new Scanner(System.in);
		System.out.printf("%s enter x and y\n", getName());//take the guess
		int x=s.nextInt();//x coordinate
		int y=s.nextInt();//y coordinate
		s.nextLine();
		if(sq[x][y].getFire()==false) {//check if the square has been fired at or not
			sq[x][y].setFired(true);//set the square has been fired at
			if(sq[x][y].getOccupancy()==true) {//check if a ship is present there
				sq[x][y].getBattleship().hit();//call the hit function from battleship class which decreases health
				System.out.println("Hit!");
				if(sq[x][y].getBattleship().getStatus()==true) {//check if the ship has sunk or not
					sq[x][y].getBattleship().setSunk(true);;//update the board with number of ships sunk
					b.setShipSunk();
					score++;//increment the points
					System.out.println("Ship Sunk, Points: "+ getScore());
				}
			}
			else {
				System.out.println("Missed!");	//if no ship is on the square guessed
				System.out.println("Points of "+ getName()+": "+getScore());
			}
		}
		else {
			System.out.println("Invalid");//if shot already fired at the square
			System.out.println("Points of "+ getName()+": "+getScore());
		}
		System.out.println(b);//toString method to display the board
		if(b.getShipSunk()==b.getTotalShips()) {
			System.out.printf("%s Won!\n", getName());
			return true;//if all the ships are sunk
		}
		else return false;//if ships are still remaining
	}
}
