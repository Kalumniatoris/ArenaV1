package ka2.tesa.players;

import java.util.ArrayList;
import java.util.Random;

public class Brandom3 extends Player {
	
	public Brandom3(int id,String name) {
		super(id,name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String go(int[][] map, int id, int n, ArrayList<Integer> scores) {
		// TODO Auto-generated method stub
		int h= map.length;
		int w= map[0].length;
		//System.out.println(h+" "+w);
		
		Random rnd=new Random();

		int x;
		int y;
		do{
			y = rnd.nextInt(h);
			x = rnd.nextInt(w);
		}while(map[x][y]==id || map[x][y]==0 && rnd.nextDouble()>0.01);
		
		return x+" "+y;
		//return null;
	}

}
