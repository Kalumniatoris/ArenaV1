package ka2.tesa.players;

import java.util.ArrayList;


public abstract class Player {
 private int id;
 private String name;
 public Player(int id, String name){
	 this.setId(id);
	 this.setName(name);
 }


 private final void setId(int id) {
	this.id=id;
}

//board, your id, number of player, current scores;
public abstract String go(int[][] map, int id, int n, ArrayList<Integer> scores);


public final int getId() {
	return id;
}


public String getName() {
	return name;
}


private void setName(String name) {
	this.name = name;
}


 
}
