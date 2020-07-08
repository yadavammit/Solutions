import java.util.LinkedList;
import java.util.Queue;

class Location{
	int x;
	int y;
	Location(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class TreasureIsland {
	public static void main(String[] args)

	{
		char[][] islandMatrix = { { 'O', 'O', 'O', 'O' }, { 'D', 'O', 'D', 'O' }, { 'O', 'O', 'O', 'O' },
				{ 'X', 'D', 'D', 'O' } };
		
		int[][] route =  new int[islandMatrix.length][islandMatrix[0].length];
		for(int i= 0 ; i< route.length ; i++){
			for (int j=0 ; j< route[0].length ; j++){
				route[i][j] = Integer.MAX_VALUE;
			}
		}
		route[0][0] =0;
		Queue<Location> qu = new LinkedList<Location>();
		qu.offer(new Location(0,0));
		int[][] change = {{0,1},{1,0},{-1,0},{0,-1}};
		int newx;
		int newy;
		while(!qu.isEmpty()){
			Location l = qu.poll();
			for(int i = 0 ; i< change.length ;i++){
				newx = l.x + change[i][0];
				newy = l.y + change[i][1];
				
				if(newx >= 0 && newx < islandMatrix.length && newy >= 0 && newy < islandMatrix[0].length){
					if(islandMatrix[newx][newy] != 'D' && route[newx][newy] == Integer.MAX_VALUE){
						route[newx][newy] = route[l.x][l.y] + 1;
						if(islandMatrix[newx][newy] == 'X'){
							System.out.println(route[newx][newy]);
						}
						qu.offer(new Location(newx,newy));
					}
				}
			}
		}
		
			
	}
}
