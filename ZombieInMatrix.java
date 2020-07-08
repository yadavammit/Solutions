import java.util.LinkedList;
import java.util.Queue;

class Zombie {
	int hour;
	int zombieLocationx;
	int zombieLocationy;
	public Zombie(int hour, int zombieLocationx, int zombieLocationy) {
		this.hour = hour;
		this.zombieLocationx = zombieLocationx;
		this.zombieLocationy = zombieLocationy;
	}
}

public class ZombieInMatrix {

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
		System.out.println(minDays(grid));
	}

	private static int minDays(int[][] grid) {
		LinkedList<Zombie> qu = new LinkedList<Zombie>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					qu.offer(new Zombie(0, i, j));
				}
			}
		}
		int[][] changes = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
		int newZombieLocationx;
		int newZombieLocationy;
		int noOfHour = 0;
		while (!qu.isEmpty()) {
			Zombie zombie = qu.poll();
			for (int i = 0; i < changes.length; i++) {
				newZombieLocationx = zombie.zombieLocationx + changes[i][0];
				newZombieLocationy = zombie.zombieLocationy + changes[i][1];
				if (newZombieLocationx >= 0 && newZombieLocationx < grid.length && newZombieLocationy >= 0
						&& newZombieLocationy < grid[0].length && grid[newZombieLocationx][newZombieLocationy] == 0) {
					qu.offer(new Zombie(zombie.hour + 1, newZombieLocationx, newZombieLocationy));
					grid[newZombieLocationx][newZombieLocationy] = 1;
				}
			}
			noOfHour = zombie.hour;
		}
		
		return noOfHour;
	}

}
