import java.util.Scanner;
public class BSMain {
	public static void main(String[] args) {
		System.out.println("New Game");
		Scanner s = new Scanner(System.in);//scanner for input
		System.out.println("Enter name of the player1");
		String nam1=s.next();//name of player 1
		System.out.println("Enter name of the player2");
		String nam2=s.next();//name of player 2
		s.nextLine();
		BSBoard bar1=new BSBoard(10,10);//board 1
		bar1.newBoard();//create new board
		System.out.println("Board 1 created");
		bar1.generateShip();//generate ships on board 1
		Player p1 = new Player(nam1);//player 1 is initialized
		BSBoard bar2=new BSBoard(10,10);
		bar2.newBoard();//create board 2
		System.out.println("Board 2 created");
		bar2.generateShip();//generate ships on board 2
		Player p2 = new Player(nam2);//player 2 is initialzed
		System.out.println("Players initialized");
		boolean win=false;//flag to check if game over not
		int turn=0;//player 1=0 code for alternating taken from lab solution of programming
		while(!win) {
			if(turn==0) win=p1.takeTurn(bar1);
			else win=p2.takeTurn(bar2);
			turn=1-turn;//alternate between player 1 and 2
		}
		System.out.println("Game Over!");
		s.close();
	}
}
