import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

	public static int n;
	public static int m;
	public static int earth[][];
	public static List<Ice> iceList;
	public static boolean isVisited[][];
	public static int dr[] = { -1, 0, 1, 0 };
	public static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		earth = new int[n][m];
		isVisited = new boolean[n][m];
		iceList = new ArrayList<>();

		// 넣기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				earth[i][j] = sc.nextInt();
				if (earth[i][j] > 0) {
					iceList.add(new Ice(i, j, earth[i][j]));
				}
				isVisited[i][j] = true;
			}
		}

		
		for (int year = 1; !iceList.isEmpty(); year++) {

			// 녹이기
			for (int i = 0; i < iceList.size(); i++) {
				Ice ice = iceList.get(i);
				for (int j = 0; j < 4; j++) {
					int nr = ice.row + dr[j];
					int nc = ice.col + dc[j];
					if (earth[nr][nc] == 0)
						ice.height--;
				}
			}

			//바다 업데이트&탐색
			for (int i = 0; i < iceList.size(); i++) {
				Ice ice = iceList.get(i);

				if (ice.height <= 0) {
					earth[ice.row][ice.col] = 0;
					iceList.set(i, iceList.get(iceList.size() - 1));
					iceList.remove(iceList.size() - 1);
					i--;
				}

				else {
					isVisited[ice.row][ice.col] = false;
				}

			}

			//얼음이 있는데 갈라진 부분이 생기면
			if (iceList.size() > 0 && iceList.size() != dfs(iceList.get(0).row, iceList.get(0).col)) {
				System.out.println(year);
				System.exit(0);
			}

		}

		System.out.println(0);

	}

	private static int dfs(int row, int col) {

		isVisited[row][col] = true;
		int count = 1;

		for (int i = 0; i < 4; i++) {

			int nr = row + dr[i];
			int nc = col + dc[i];

			if (isVisited[nr][nc]) {
				continue;
			}
			count += dfs(nr, nc);

		}

		return count;

	}

}

class Ice {

	public Ice(int row, int col, int height) {
		this.row = row;
		this.col = col;
		this.height = height;
	}

	int row;
	int col;
	int height;

}