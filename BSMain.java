import java.util.Scanner;

/*
 * Name: Praharsh R Dubey
 * GUID: 2738037D
 */
public class BSMain {
	public static void main(String[] args) {
		System.out.println("New Game");
		Scanner s = new Scanner(System.in);//scanner for input
		System.out.println("Enter name of the player1");
		String nam1=s.next();//name of player 1
		System.out.println("Enter name of the player2");
		String nam2=s.next();//name of player 2
		s.nextLine();
		
		/*
		 * In order to play for original battleship game with 5 ships, please comment the lines indicated in BSMain.java and Player.java
		*/
		
		
		
		
		//uncomment for original battleship game
//		board b1=new board(10,10);//board 1 for original battleship task
//		b1.newBoard();
//		System.out.println("Board 1 created");
//		b1.generateShip();//generate ships on board 1
//		board b2=new board(10,10);//board 2 for original battleship task
//		b2.newBoard();
//		System.out.println("Board 2 created");
//		b2.generateShip();//generate ships on board 1
//		Player p1 = new Player(nam1, b1);//player 1 is initialized
//		Player p2 = new Player(nam2,b2);//player 2 is initialized
		
		//comment this block to play for original battleship task
		BSBoard bar1=new BSBoard(10,10);//board 1 for task 5
		bar1.newBoard();//create new board
		System.out.println("Board 1 created");
		bar1.generateShip();//generate ships on board 1
		BSBoard bar2=new BSBoard(10,10);
		bar2.newBoard();//create board 2 for task 5
		System.out.println("Board 2 created");
		bar2.generateShip();//generate ships on board 2
		Player p1 = new Player(nam1, bar1);//player 1 is initialized
		Player p2 = new Player(nam2,bar2);//player 2 is initialized
		
		
		System.out.println("Players initialized");
		boolean win=false;//flag to check if game over not
		int turn=0;//player 1=0 code for alternating taken from lab solution of programming
		while(!win) {
			if(turn==0) win=p1.takeTurn();//for task 5 board
			else win=p2.takeTurn();//for task 5 board
			turn=1-turn;//alternate between player 1 and 2
		}
		System.out.println("Game Over!");
		if(p1.getScore()>p2.getScore()) System.out.println(p1.getName()+" Won!");//if player 1 wins
		else if(p1.getScore()<p2.getScore()) System.out.println(p2.getName()+ " Won!");//if player 2 wins
		else System.out.println("Draw!");//in case of a draw
		s.close();
	}
}
