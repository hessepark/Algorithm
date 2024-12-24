import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static char maze[][];
	public static int isVisited[][];
	public static int isBurned[][];
	public static int dr[] = { -1, 0, 1, 0 };
	public static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {

			int w = sc.nextInt();
			int h = sc.nextInt();

			maze = new char[h][w];
			isVisited = new int[h][w];
			isBurned = new int[h][w];

			ArrayDeque<Point> fire = new ArrayDeque<>();
			ArrayDeque<Point> sang = new ArrayDeque<>();

			for (int i = 0; i < h; i++) {
				String str = sc.next();
				for (int j = 0; j < w; j++) {
					maze[i][j] = str.charAt(j);
					if (maze[i][j] == '@') {
						sang.add(new Point(i, j));
						isVisited[i][j] = 1;
					}
					if (maze[i][j] == '*') {
						fire.add(new Point(i, j));
						isBurned[i][j] = 1;
					}
				}
			}

			while (!fire.isEmpty()) {
				Point now = fire.poll();

				for (int i = 0; i < 4; i++) {

					int nr = now.r + dr[i];
					int nc = now.c + dc[i];

					if (nr == -1 || nc == -1 || nr == h || nc == w || maze[nr][nc] == '#') {
						continue;
					}

					if (isBurned[nr][nc] == 0) {
						isBurned[nr][nc] = isBurned[now.r][now.c] + 1;
						fire.add(new Point(nr, nc));
					}

				}
			}

//			for (int i = 0; i < h; i++) {
//				System.out.println(Arrays.toString(isBurned[i]));
//			}
			
			boolean isPossible=false;

			while (!sang.isEmpty()) {
				Point now = sang.poll();

				if (now.r == 0 || now.c == 0 || now.r == h - 1 || now.c == w - 1) {
					if (isVisited[now.r][now.c] < isBurned[now.r][now.c]||isBurned[now.r][now.c]==0) { //도착했는데 불탄 흔적이 없어도 ok || 뒤에 구문
						System.out.println(isVisited[now.r][now.c] );
						isPossible=true;
						break;
					}
				}

				for (int i = 0; i < 4; i++) {

					int nr = now.r + dr[i];
					int nc = now.c + dc[i];

					if (nr == -1 || nc == -1 || nr == h || nc == w || maze[nr][nc] == '#' || maze[nr][nc] == '*') {
						continue;
					}

					if (isVisited[nr][nc] == 0) { //안 가본곳 가는 코드
						isVisited[nr][nc] = isVisited[now.r][now.c] + 1;
						sang.add(new Point(nr, nc));
						
						// ※종료 구문을 끝에 넣으면 출입구 쪽에 있을 때 처리가 안 됨 (마찬가지로 숨바꼭질 문제도 이러한 문제가 있었다)
//						if(nr==0||nc==0||nr==h-1||nc==w-1) {
//							if (isVisited[nr][nc] < isBurned[nr][nc]||isBurned[nr][nc]==0) { //도착했는데 불탄 흔적이 없어도 ok || 뒤에 구문
//								System.out.println(isVisited[nr][nc] );
//								isPossible=true;
//								break;
//							}
//						}
						
					}

				}
			}
			
			if(!isPossible) {
				System.out.println("IMPOSSIBLE");
			}

		}

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