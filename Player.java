import java.util.Scanner;

/*
 * Name: Praharsh R Dubey
 * GUID: 2738037D
 */

public class Player {
	//attributes
	private String name;//name
	private int score;//score
	private board bord1;
	private BSBoard BSbord1;
	
	//constructor
	public Player(String n, BSBoard BSbord1) {//constructor for task 5 board
		this.name=n;
		this.score=0;//default value
		this.BSbord1=BSbord1;
	}
	public Player(String n, board bord1) {//constructor for original board
		this.name=n;
		this.score=0;//default value
		this.bord1=bord1;
	}
	
	//methods
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public boolean takeTurn() {//takeTurn for task 5 and original board
		
		//uncomment to play for task 5
		Square[][] sq=BSbord1.getBoard();//get the current board
		
		//uncomment to run original bord
//		Square[][] sq=bord1.getBoard();//get the current board
		
		
		Scanner s=new Scanner(System.in);
		System.out.printf("%s enter x and y\n", getName());//take the guess
		int x=s.nextInt();//x coordinate
		int y=s.nextInt();//y coordinate
		s.nextLine();
		if(sq[x][y].getFire()==false) {//check if the square has been fired at or not
			sq[x][y].setFired(true);//set the square has been fired at
			if(sq[x][y].getOccupancy()==true) {//check if a ship is present there
				sq[x][y].getBattleship().hit();//call the hit function from battleship class which decreases health
				System.out.println("Points of "+ getName()+": "+getScore());
				System.out.println("Hit!");
				if(sq[x][y].getBattleship().getStatus()==true) {//check if the ship has sunk or not
					sq[x][y].getBattleship().setSunk(true);//update the board with number of ships sunk
					
					//uncomment to play for task 5
					BSbord1.setShipSunk();//increment the number of ships sunk
					
					//uncomment to run original board
//					bord1.setShipSunk();
					
					score++;//increment the points
					System.out.println("Ship Sunk, Points updated to: "+ getScore());//display on the console
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
		System.out.println("Current State");
		
		//uncomment to play for task 5
		System.out.println(BSbord1);//toString method to display the board
		
		//uncomment next line to play for original board
//		System.out.println(bord1);//toString method to display original board
		
		//uncomment to play for task 5
		if(BSbord1.getShipSunk()==BSbord1.getTotalShips()) return true;//if all the ships are sunk
		else return false;//if ships are still remaining
		
		//uncomment to run original board
//		if(bord1.getShipSunk()==bord1.getTotalShips()) return true;//if all the ships are sunk
//		else return false;//if ships are still remaining
		
	}

}
