import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

	public static int n, m;
	public static int earth[][];
	public static boolean check[][];
	public static ArrayList<Ice> list;
	public static int dr[] = { -1, 0, 1, 0 };
	public static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		check = new boolean[n][m];
		earth = new int[n][m];
		list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				earth[i][j] = sc.nextInt();
				if (earth[i][j] > 0) {
					list.add(new Ice(i, j, earth[i][j]));
				}
				check[i][j] = true;
			}
		}

		for (int year = 1; !list.isEmpty(); year++) {// 이거

			// 얼음 녹이기
			for (Ice ice : list) {
				for (int k = 0; k < 4; k++) {
					int nr = dr[k] + ice.r;
					int nc = dc[k] + ice.c;

					if (earth[nr][nc] == 0) {
						ice.h--;
					}

				}
			}

			// 녹인 얼음 대입하기
			for (int i = 0; i < list.size(); i++) {
				Ice ice = list.get(i);
				if (ice.h <= 0) {
					earth[ice.r][ice.c] = 0;
					list.set(i, list.get(list.size() - 1));
					list.remove(list.size() - 1);
					i--;// 이거
				} else {
					check[ice.r][ice.c] = false;
				}
			}

			if (list.size() > 0 && bfs(list.get(0).r, list.get(0).c) != list.size()) {
				System.out.println(year);
				System.exit(0);
			}
		}
		System.out.println(0);

	}

	public static int bfs(int r, int c) {
		int cnt = 0;
		check[r][c] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] current = q.poll();
			int cr = current[0];
			int cc = current[1];
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (!check[nr][nc]) {
					q.add(new int[] { nr, nc });
					check[nr][nc] = true;
				}

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