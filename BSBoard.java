import java.util.Random;
public class BSBoard {
	//attributes
	private int row;//row
	private int coloumn;//coloumn
	private Square[][] board=null;
	private int shipSunk;//no of ships sunk
	//constructor
	public BSBoard(int a, int b) {
		this.row=a;
		this.coloumn=b;
	}
	
	//methods
	public void newBoard() {
//		System.out.println("Row: "+row);
		board=new Square[row][coloumn];
		for(int i=0;i<row;i++) {
			for(int j=0;j<coloumn;j++) {
				board[i][j]=new Square(i,j);//creating board
			}
		}
		
	}
	
	public void generateShip() {//generating and placing ships
		boolean successPlace;
		boolean holdCoin;
		
		for(int i=0;i<5;) {
			Battleship b= new Battleship();
			successPlace=false;//boolean for successful placement of ship
			holdCoin=coinFlip();//boolean to hold the value of random coin flip
//			System.out.println("Coin: " + holdCoin);
			while(!successPlace){
				if(holdCoin==true) {//vertical placement of ship
					Random r = new Random();
					int xcord=r.nextInt(row);
					int ycord=r.nextInt(coloumn);//random generation of x, y coordinates
					if((xcord>0 && xcord<this.row) && (xcord+1>0 && xcord+1<this.row) && (ycord>0 && ycord<this.coloumn)) {//check for board constraints
						if((board[xcord][ycord].getOccupancy()==false) && (board[xcord+1][ycord].getOccupancy()==false)) {//checking for occupancy of squares
							board[xcord][ycord].setOccupancy(true);//occupy the square
							board[xcord][ycord].setBattleship(b);
							board[xcord+1][ycord].setOccupancy(true);//occupy the vertically adjacent square
							board[xcord+1][ycord].setBattleship(b);
							System.out.println("ship "+(i+1) +" placed vertically at "+ xcord + ","+ ycord +" and "+ (xcord+1) + ","+ ycord);
							i++;
							successPlace=true;
						}
//						else {
//							System.out.println("Ship Already occupying space");
//						}					
					}
//					else {
//		                System.out.println("You can't place ships outside the board");
//					}
				}
				else {//horizontal placement of ship
					Random r = new Random();
					int xcord=r.nextInt(row);
					int ycord=r.nextInt(coloumn);//random generation of x, y coordinates
					if((xcord>0 && xcord<this.row) && (ycord>0 && ycord<this.coloumn) && (ycord+1>0 && ycord+1<this.row)) {//check for board constraints
						if((board[xcord][ycord].getOccupancy()==false) && (board[xcord][ycord+1].getOccupancy()==false)) {//checking for occupancy of squares
							board[xcord][ycord].setOccupancy(true);//occupy the square
							board[xcord][ycord].setBattleship(b);
							board[xcord][ycord+1].setOccupancy(true);//occupy the horizontally adjacent square
							board[xcord][ycord+1].setBattleship(b);
							System.out.println("ship "+(i+1) +" placed horizontally at "+ xcord + ","+ ycord +" and "+ xcord + ","+ (ycord+1));
							i++;
							successPlace=true;
						}
//						else {
//							System.out.println("Ship Already occupying space");
//						}
					}
//					else {
//		                System.out.println("You can't place ships outside the board");
//					}
				}
			}
		}
			
	}
	public boolean coinFlip() {
		Random r= new Random();
		return r.nextBoolean();
	}
	public int getShipSunk() {
		return shipSunk;
	}
	public void setShipSunk() {
		this.shipSunk++;
	}
	public Square[][] getBoard(){
		return board;
	}
	public String toString() {
		String hit="x";
		String miss="o";
		String water="-";
		String s="";
		for(int i=0;i<this.row;i++) {
			for(int j=0;j<this.coloumn;j++) {
				if(board[i][j].getFire()==true) {
					if(board[i][j].getOccupancy()==true) {
						s+=String.format("%3s", hit);
					}
					else s+=String.format("%3s",miss);
				}
				else s+=String.format("%3s",water);
			}
			s+="\n";
		}
		return s;
	}
}
