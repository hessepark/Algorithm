import java.util.ArrayDeque;
import java.util.Scanner;

class Main {

	public static int dr[] = { -1, 0, 1, 0 };
	public static int dc[] = { 0, 1, 0, -1 };
	public static int isVisited[][][];
	public static int maze[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		isVisited = new int[n + 1][m + 1][k+1];
		maze = new int[n + 1][m + 1];

		for (int i = 1; i < n + 1; i++) {
			String str = sc.next();
			for (int j = 1; j < m + 1; j++) {
				maze[i][j] = str.charAt(j-1) - '0';
			}
		}

		ArrayDeque<Point> q = new ArrayDeque<>();
		q.add(new Point(1, 1, 0));
		isVisited[1][1][0] = 1;

		while (!q.isEmpty()) {

			Point now = q.poll();
			if (now.r == n && now.c == m) {
				System.out.println(isVisited[now.r][now.c][now.isBroken]);
				return;
			}

			for (int i = 0; i < 4; i++) {

				int nr = dr[i] + now.r;
				int nc = dc[i] + now.c;

				if (nr == 0 || nc == 0 || nr == n + 1 || nc == m + 1) {
					continue;
				}

				if (isVisited[nr][nc][now.isBroken] == 0 && maze[nr][nc] == 0) {
					isVisited[nr][nc][now.isBroken] = isVisited[now.r][now.c][now.isBroken] + 1;
					q.add(new Point(nr, nc, now.isBroken));
				} else if (now.isBroken < k&&isVisited[nr][nc][now.isBroken+1] == 0) {
					isVisited[nr][nc][now.isBroken+1] = isVisited[now.r][now.c][now.isBroken] + 1;
					q.add(new Point(nr, nc, now.isBroken+1));
				}

			}

		}
		
		System.out.println(-1);

	}
}

class Point {
	int r;
	int c;
	int isBroken;

	public Point(int r, int c, int isBroken) {
		this.r = r;
		this.c = c;
		this.isBroken = isBroken;
	}
}