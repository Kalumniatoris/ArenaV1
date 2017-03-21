package ka2.tesa;

import java.util.ArrayList;

import ka2.tesa.players.Player;

public class Board {
	private int height;
	private int width;
	private int[][] map;
	private int tmp[][];
	private int nPlayers;
	private ArrayList<Player> players;
	private ArrayList<Integer> score;

	private Player dummy;
	
	public Board(int h, int w) {
		dummy=new Player(0,"0") {
			
			@Override
			public String go(int[][] map, int id, int n, ArrayList<Integer> scores) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		this.height = h;
		this.width = w;
		map = new int[h][w];
		tmp = new int[h][w];
		setnPlayers(0);
		clearMap();
		
		setPlayers(new ArrayList<Player>());
		players.add(dummy);
		
		score=new ArrayList<Integer>();
		
		// TODO Auto-generated constructor stub
	}

	private void clearMap() {
		for (int x = 0; x < this.width; x += 1) {
			for (int y = 0; y < this.height; y += 1) {
				map[x][y] = 0;
			}
		}

	}

	private void clearTmp() {
		for (int x = 0; x < this.width; x += 1) {
			for (int y = 0; y < this.height; y += 1) {
				tmp[x][y] = 0;
			}
		}

	}

	public int[][] getMap() {
		return map;
	}

	public void addPlayer(Player p) {
		getPlayers().add(p);
		setnPlayers(getnPlayers() + 1);
	}

	public void run(int moves) {
		for (int i = 0; i < moves; i += 1) {
			clearTmp();
			for (Player p : getPlayers()) {
				this.move(
						p,
						p.go(map, p.getId(), this.getnPlayers(),
								this.getScore()));
			}
			this.updateBoard();
			this.claim();
			this.updateScores();
		}

	}

	private void claim() {
		this.clearTmp();
		for (int x = 1; x < this.width-1; x += 1) {
			for (int y = 1; y < this.height-1; y += 1) {
				if (map[x - 1][y - 1] == map[x - 1][y]) {
					if (allEqual(
							map[x - 1][y],
							map[x][y - 1],
							map[x][y + 1],
							map[x + 1][y]
						         )
						) {
						tmp[x][y]=map[x-1][y];
					}
				}
			}
		}
		this.updateBoardVTwo();
		// TODO Auto-generated method stub

	}

	public boolean allEqual(Object... objs) {
		if (objs.length < 2)
			return true; // 0 or 1 objects are all equal
		Object key = objs[0]; // pick one
		for (Object o : objs)
			if (!o.equals(key))
				return false;
		return true;
	}

	private void updateScores() {
		for (int x = 0; x < this.width; x += 1) {
			for (int y = 0; y < this.height; y += 1) {
				score.set(map[x][y], score.get(map[x][y]) + 1);
			}
		}

	}

	private void move(Player player, String move) {
		if(move==null)return;
		String command[] = move.split(" ");
		if (command.length != 2)
			return;
		int x = Integer.parseInt(command[0]);
		int y = Integer.parseInt(command[0]);
		if (x >= 0 && x < this.width && y >= 0 && y < this.height) {
			if (tmp[x][y] == 0) {
				tmp[x][y] = player.getId();
			} else {
				tmp[x][y] = -1;
			}
		} else {
			return;
		}

	}
	public String getPlayerName(int id){
		return getPlayers().get(id).getName();
	}
	
	public void updateBoard() {
		for (int x = 0; x < this.width; x += 1) {
			for (int y = 0; y < this.height; y += 1) {
				if (tmp[x][y] > 0) {
					if (map[x][y] == tmp[x][y]) {
						map[x][y] = 0;
					} else {
						map[x][y] = tmp[x][y];
					}
				}
			}
		}
	}

	public void updateBoardVTwo() {
		for (int x = 0; x < this.width; x += 1) {
			for (int y = 0; y < this.height; y += 1) {
				if (tmp[x][y] > 0) {
					
						map[x][y] = tmp[x][y];
					
				}
			}
		}
	}
	
	public int getnPlayers() {
		return nPlayers;
	}

	public void setnPlayers(int nPlayers) {
		this.nPlayers = nPlayers;
	}

	public ArrayList<Integer> getScore() {
		return score;
	}

	public void setInitScore() {
		for (int i = 0; i <= this.getnPlayers(); i += 1) {
			score.add(i, 0);
		}

	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
}
