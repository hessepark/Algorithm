import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	// 상하좌우 보면서 바로 갈 수 있는 거 넣고,
	// 벽 하나 부수고 갈 수 있는 거 넣는다.
	public static int maze[][];
	public static int isVisited[][][];
	public static int isCrush[][];
	public static int dr[] = { -1, 0, 1, 0 };
	public static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		maze = new int[n][m];
		isVisited = new int[n][m][2];

		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}

		// 벽 안 부수고 갈 수 있는 최단거리

		ArrayDeque<Point> q = new ArrayDeque<>();
		isVisited[0][0][0] = 1;
		q.add(new Point(0, 0, 0));

		while (!q.isEmpty()) {
			Point now = q.poll();

			if (now.r == n - 1 && now.c == m - 1) {
				
//				for(int i=0;i<n;i++) {
//					for(int j=0;j<m;j++) {
//						System.out.printf("%02d ", isVisited[i][j][0]);
//					}
//					System.out.println();
//				}
//				
//				System.out.println();
//				
//				for(int i=0;i<n;i++) {
//					for(int j=0;j<m;j++) {
//						System.out.printf("%02d ", isVisited[i][j][1]);
//					}
//					System.out.println();
//				}
				
				
				System.out.println(isVisited[now.r][now.c][now.crush]);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + now.r;
				int nc = dc[i] + now.c;

				if (nr == -1 || nc == -1 || nr == n || nc == m) {
					continue;
				}

				if (isVisited[nr][nc][now.crush] == 0) {
					if (maze[nr][nc] == 0) { //그 위치까지 부수고 간 것인지, 아닌지는 알고 있어야함
						isVisited[nr][nc][now.crush] = isVisited[now.r][now.c][now.crush] + 1;
						q.add(new Point(nr, nc, now.crush));
					} else if (maze[nr][nc] == 1 && now.crush == 0&&isVisited[nr][nc][1]==0) { 
						q.add(new Point(nr, nc, 1));
						isVisited[nr][nc][1]=isVisited[now.r][now.c][now.crush]+1;
					}
				}

			}
		}
		
		System.out.println(-1);
	}
	
}

class Point {
	int r;
	int c;
	int crush;

	public Point(int r, int c, int crush) {
		this.r = r;
		this.c = c;
		this.crush = crush;
	}
}