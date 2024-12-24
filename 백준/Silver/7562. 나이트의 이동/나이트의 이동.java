import java.util.ArrayDeque;
import java.util.Scanner;

class Main {

	public static int isVisited[][];
	public static int l;
	public static int sR, sC, eR, eC;
	public static int dr[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
	public static int dc[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {

			l = sc.nextInt();
			isVisited = new int[l][l];

			sR = sc.nextInt();
			sC = sc.nextInt();
			eR = sc.nextInt();
			eC = sc.nextInt();

			bfs();

			System.out.println(isVisited[eR][eC]);
		}
	}

	public static void bfs() {

		ArrayDeque<Pos> q = new ArrayDeque<>();
		q.add(new Pos(sR, sC));
		//System.out.println(sR+" "+sC);
		isVisited[sR][sC] = 0;

		while (!q.isEmpty()) {
			Pos now = q.poll();
			
			if(now.r==eR&&now.c==eC) {
				return;
			}
			
			for (int i = 0; i < 8; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= l || nc >= l) {
					continue;
				}

				if (isVisited[nr][nc] == 0) {
					isVisited[nr][nc] = isVisited[now.r][now.c] + 1;
					q.add(new Pos(nr,nc));
				}

			}
		}

	}
}

class Pos {
	int r;
	int c;

	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}