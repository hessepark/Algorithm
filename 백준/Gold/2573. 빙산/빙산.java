import java.util.ArrayList;
import java.util.Scanner;

class Main {

	public static int n, m;
	public static ArrayList<Ice> list;
	public static int earth[][];
	public static boolean isVisited[][];

	public static int dr[] = { -1, 0, 1, 0 };
	public static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		list = new ArrayList<>();
		earth = new int[n][m];
		isVisited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				earth[i][j] = sc.nextInt();
				if (earth[i][j] > 0) {
					list.add(new Ice(i, j, earth[i][j]));
				}
				isVisited[i][j] = true;
			}
		}

		for (int year = 1; !list.isEmpty(); year++) {

			// 얼음 녹이기
			for (int i = 0; i < list.size(); i++) {

				for (int k = 0; k < 4; k++) {
					int nr = dr[k] + list.get(i).r;
					int nc = dc[k] + list.get(i).c;

					if (earth[nr][nc] == 0) {
						list.get(i).h--;
					}

				}

			}
//			for(Ice ice:list) {
//				
//			}
			// 녹인 얼음 대입
			for (int i = 0; i < list.size(); i++) {

				if (list.get(i).h <= 0) {
					earth[list.get(i).r][list.get(i).c]=0;
					list.set(i, list.get(list.size() - 1));
					list.remove(list.size() - 1);
					i--;
				} else {
					isVisited[list.get(i).r][list.get(i).c] = false;
				}

			}

			if (list.size() > 0 && dfs(list.get(0).r, list.get(0).c) != list.size()) {
				System.out.println(year);
				return;
			}

		}
		System.out.println(0);

	}

	public static int dfs(int r, int c) {

		int cnt = 1;
		isVisited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;

			if (!isVisited[nr][nc]) {
				cnt += dfs(nr, nc);
			}
		}
		return cnt;

	}
}

class Ice {
	int r;
	int c;
	int h;

	public Ice(int r, int c, int h) {
		this.r = r;
		this.c = c;
		this.h = h;
	}
}