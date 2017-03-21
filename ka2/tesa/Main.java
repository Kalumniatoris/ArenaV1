package ka2.tesa;

import ka2.tesa.players.Brandom;
import ka2.tesa.players.Brandom2;
import ka2.tesa.players.Brandom3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int h=100;
		int w=100;
		Board board=new Board(h, w);
		
		//addPlayers
		
		board.addPlayer(new Brandom(1,"Brandom"));
		board.addPlayer(new Brandom2(2,"Brandom2"));
		board.addPlayer(new Brandom3(3,"Brandom3"));
		
		//initScores;
		board.setInitScore();
		
		
		board.run(1000);
		int i=0;
		for (Integer score : board.getScore()) {
			String n = board.getPlayers().get(i).getName();
			System.out.println(n+":"+score);
			i+=1;
		}
		
	}

}
