import java.util.Scanner;
public class BSMain {
	public static void main(String[] args) {
		System.out.println("New Game");
		Scanner s = new Scanner(System.in);//scanner for input
		System.out.println("Enter name of the player1");
		String nam1=s.next();
		System.out.println("Enter name of the player2");
		String nam2=s.next();
		s.nextLine();
		BSBoard bar1=new BSBoard(10,10);
		bar1.newBoard();
		System.out.println("Board 1 created");
		bar1.generateShip();
		Player p1 = new Player(nam1);//player 1 is initialized
		BSBoard bar2=new BSBoard(10,10);
		bar2.newBoard();
		System.out.println("Board 2 created");
		bar2.generateShip();
		Player p2 = new Player(nam2);//player 2 is initialzed
		System.out.println("Players initialized");
		boolean win=false;
		int turn=0;//player 1=0
		while(!win) {
			if(turn==0) win=p1.takeTurn(bar1);
			else win=p2.takeTurn(bar2);
			turn=1-turn;//alternate between turns
		}
	}
}