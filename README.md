# ArenaV1


This is turn based game where all players moves simultaneously.
Game take place on rectangular board, where initially all boxes are empty.
At start of turn each player declare where they would like to place their token, there are 4 possible outcomes:
1. Other player selected the same box in current round : nothing happens on selected box (Override rest of options)
2. Selected box is empty or belong to other player : box is now belong to player who selected it
3. Player selected their own box : box is now empty
4. Incorrect answer (e.g. out of board): Player forfeit their turn. (aka does nothing in this turn)

After that players receive boxes that are surrounded by their tokens (only cardinal directions are needed)
e.g. 
```
000100            000100
001010   Creates: 001110
000100            000100
000000            000000
```  

e.g.2

```
000100            000100
001210   Creates: 001110
002120            002220
000200            000200
```  

After that each player gains points according to amount of boxes he own. (1 per box)

BOTS:
each bot need to extend class Player, and implement function go(...) that will run at start of each turns.

Arguments of function (what your bot gets):
go(int[][] map, int id, int nPlayers, ArrayList<Integer> scores);
map: current board as 2d array, values show current owners of adequate boxes, 0 - empty box.
id: your id;
nPlayers: number of players in game.
scores: List of current scores, where id of element in array match id of player (scores.get(1) return curent score of player with id 1)

Output:
function need to return string with coordinates of selected box "x y" e.g: "3 5" (without "s obviously)
