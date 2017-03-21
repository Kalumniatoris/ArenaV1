package ka2.tesa.players;

import java.util.ArrayList;
import java.util.Random;

public class Brandom2 extends Player {

	public Brandom2(int id,String name) {
		super(id,name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String go(int[][] map, int id, int n, ArrayList<Integer> arrayList) {
		// TODO Auto-generated method stub
		int h= map.length;
		int w= map[0].length;
		//System.out.println(h+" "+w);
		
		Random rnd=new Random();
		return rnd.nextInt(w)+" "+rnd.nextInt(h);
		//return null;
	}

}
