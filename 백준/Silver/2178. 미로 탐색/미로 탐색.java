import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static int n, m;
	public static int isVisited[][];
	public static int maze[][];

	public static int dr[] = { -1, 0, 1, 0 };
	public static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		isVisited = new int[n + 1][m + 1];
		maze = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			String str = sc.next();
			for (int j = 1; j <= m; j++) {
				maze[i][j] = str.charAt(j - 1) - '0';
			}
		}
		
		//System.out.println(Arrays.toString(maze[1]));

		ArrayDeque<Point> q = new ArrayDeque<>();
		q.add(new Point(1, 1));
		isVisited[1][1]=1;
		
		while (!q.isEmpty()) {
			Point now = q.pollFirst();
			
			//System.out.println(q);

			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];

				if (nr == 0 || nc == 0 || nr > n || nc > m) {
					continue;
				}

				if (isVisited[nr][nc] == 0 && maze[nr][nc] == 1) { //가본 적 없고 갈 수 있으면
					isVisited[nr][nc]=isVisited[now.r][now.c]+1;
					q.add(new Point(nr, nc));
				}

			}
		}
		
		System.out.println(isVisited[n][m]);

	}
}

class Point {
	int r;
	int c;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}