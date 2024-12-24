import java.util.ArrayDeque;
import java.util.Scanner;

class Main {

	public static int n, m;
	public static int day;
	public static int ans;
	public static int currentT;
	public static int targetT;
	public static boolean isVisited[][];
	public static int days[][];// 어느 시점에 들어갔는지
	public static int box[][];
	public static ArrayDeque<Pos> q;
	public static int dr[] = { 1, 0, -1, 0 };
	public static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		m = sc.nextInt();
		n = sc.nextInt();

		q = new ArrayDeque<>();
		isVisited = new boolean[n][m];
		box = new int[n][m];
		day = 0;
		ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				box[i][j] = sc.nextInt();
				if (box[i][j] != -1) {
					targetT++;
				}
				if (box[i][j] == 1) {
					currentT++;
					q.add(new Pos(i, j, 0));
					isVisited[i][j] = true;
				}
			}
		}

		if (currentT == targetT) {
			System.out.println(day);
			return;
		}

		else
			bfs();
		
		//System.out.println("currentT"+currentT);
		//System.out.println("targetT"+targetT);

		if (currentT != targetT) {
			day = -1;
		}

		System.out.println(day);

	}

	public static void bfs() {

		while (!q.isEmpty()) {
			Pos now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];

				if (nr == n || nc == m || nr == -1 || nc == -1) {
					continue;
				}

				if (!isVisited[nr][nc] && box[nr][nc] == 0) {
					//System.out.println(nr + " " + nc);
					isVisited[nr][nc] = true;
					box[nr][nc] = 1;
					currentT++;
					q.add(new Pos(nr, nc, now.day + 1));
				}
			}
			//System.out.println();

			if (currentT == targetT) {
				day = now.day + 1;
				return;
			}

		}

	}

}

class Pos {
	int r;
	int c;
	int day;

	public Pos(int r, int c, int day) {
		this.r = r;
		this.c = c;
		this.day = day;// 어느 시점에 들어갔는지
	}
}