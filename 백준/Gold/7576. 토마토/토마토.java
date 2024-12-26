import java.util.ArrayDeque;
import java.util.Scanner;

class Main {

	public static int dr[] = { -1, 0, 1, 0 };
	public static int dc[] = { 0, 1, 0, -1 };

	public static int box[][];
	public static int isVisited[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		box = new int[n][m];
		isVisited = new int[n][m];

		ArrayDeque<Point> q = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				box[i][j] = sc.nextInt();
				if (box[i][j] > 0) {
					q.add(new Point(i, j));
					isVisited[i][j] = 1;
				}
			}
		}

		// 익히기
		while (!q.isEmpty()) {
			Point now = q.poll();

			for (int i = 0; i < 4; i++) {

				int nr = now.r + dr[i];
				int nc = now.c + dc[i];

				if (nr == -1 || nc == -1 || nr == n || nc == m) {
					continue;
				}

				if (isVisited[nr][nc] == 0&&box[nr][nc]==0) {
					isVisited[nr][nc] = isVisited[now.r][now.c] + 1;
					q.add(new Point(nr,nc));
					//System.out.println(nr+" "+nc);
				}

			}
		}

		// 최댓값 찾기

		int max = Integer.MIN_VALUE;
		boolean isPossible = true;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 0 && isVisited[i][j] == 0) {
					isPossible = false;
					break;
				}
				max = Math.max(max, isVisited[i][j]);
			}
			if (!isPossible) {
				break;
			}
		}
		
		if(!isPossible) {
			System.out.println(-1);
		}
		
		else System.out.println(max-1);

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