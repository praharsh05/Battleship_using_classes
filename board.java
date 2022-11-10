import java.util.Random;

/*
 * Name: Praharsh R Dubey
 * GUID: 2738037D
 */


public class board {//board class for original task of 5 battleship of size and health 2
	//attributes
		private int row;//row
		private int coloumn;//column
		private Square[][] board;
		private int shipSunk;//no of ships sunk
		private int totalShips=5;//total number of ships
		private Battleship b;//referencing battleship
		
		//constructor
		public board(int a, int b) {
			this.row=a;
			this.coloumn=b;
			this.board=null;//default initialization
			this.shipSunk=0;//default initialization
		}
		//methods
		public void newBoard() {//create new board
			board=new Square[row][coloumn];
			for(int i=0;i<row;i++) {
				for(int j=0;j<coloumn;j++) {
					board[i][j]=new Square(i,j);//populating board with square objects
				}
			}
		}
		
		public void generateShip() {//generating and placing ships
			boolean successPlace;//boolean to check if ship placed successfully
			boolean holdCoin;//boolean to hold the value of coin toss
			for(int i=0;i<totalShips;) {//counter to place 6 ships on the board when 
				b=new Battleship();//creating a new battleship every time
				successPlace=false;//boolean for successful placement of ship
				holdCoin=coinFlip();//boolean to hold the value of random coin flip
				while(!successPlace){//run until successful placement of ship
					if(holdCoin==true) {//vertical placement of ship
						Random r = new Random();
						int xcord=r.nextInt(row);
						int ycord=r.nextInt(coloumn);//random generation of x, y coordinates
						if((xcord>=0 && xcord<this.row) && (xcord+1>=0 && xcord+1<this.row) && (ycord>=0 && ycord<this.coloumn)) {//check for board constraints
							if((board[xcord][ycord].getOccupancy()==false) && (board[xcord+1][ycord].getOccupancy()==false)) {//checking for occupancy of squares
								board[xcord][ycord].setOccupancy(true);//occupy the square
								board[xcord][ycord].setBattleship(b);//set a ship on the square
								board[xcord+1][ycord].setOccupancy(true);//occupy the vertically adjacent square
								board[xcord+1][ycord].setBattleship(b);//set a ship on the square
								System.out.println(" ship "+(i+1) +" placed vertically at "+ xcord + ","+ ycord +" and "+ (xcord+1) + ","+ ycord);
								i++;//increment the ship placed as it was successful
								successPlace=true;//boolean turned to true
							}					
						}
					}
					else{//horizontal placement of ship
						Random r = new Random();
						int xcord=r.nextInt(row);
						int ycord=r.nextInt(coloumn);//random generation of x, y coordinates
						if((xcord>=0 && xcord<this.row) && (ycord>=0 && ycord<this.coloumn) && (ycord+1>=0 && ycord+1<this.row)) {//check for board constraints
							if((board[xcord][ycord].getOccupancy()==false) && (board[xcord][ycord+1].getOccupancy()==false)) {//checking for occupancy of squares
								board[xcord][ycord].setOccupancy(true);//occupy the square
								board[xcord][ycord].setBattleship(b);//set a ship on the square
								board[xcord][ycord+1].setOccupancy(true);//occupy the horizontally adjacent square
								board[xcord][ycord+1].setBattleship(b);//set a ship on the square
								System.out.println(" ship "+(i+1) +" placed horizontally at "+ xcord + ","+ ycord +" and "+ xcord + ","+ (ycord+1));
								i++;//increment the ship placed as it was successful
								successPlace=true;//boolean turned to true
								}
							}
						}
				}
			}
		}
		
		public boolean coinFlip() {//method to get random vertical or horizontal
			Random r= new Random();
			return r.nextBoolean();
		}
		public int getShipSunk() {//return the how many ships are sunk
			return shipSunk;
		}
		public int getTotalShips() {//get total ships placed on the board
			return totalShips;
		}
		public void setShipSunk() {//increment the number of ships sunk
			this.shipSunk++;
		}
		public Square[][] getBoard(){//return the status of the board
			return board;
		}
		public String toString() {//display the changes on the board
			
			String s="";//initial string
			for(int i=0;i<this.row;i++) {
				for(int j=0;j<this.coloumn;j++) {
					s+=board[i][j];//invoking the toString of the square
				}
				s+="\n";//new line after the column loop finishes
			}
			return s;//return the string
		}
}
