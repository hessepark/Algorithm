import java.util.Scanner;

class Main {

	public static int node[];
	public static int depth[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();

			node = new int[n + 1];
			depth = new int[n + 1];

			for (int i = 1; i < n + 1; i++) {
				node[i] = sc.nextInt();
			}

			int cnt = 0;
			for (int i = 1; i < n + 1; i++) {
				if (depth[i] == 0) {
					depth[i] = 1;
					cnt += dfs(i);
				}
			}
			System.out.println(n - cnt);

		}

	}

	public static int dfs(int num) {

		int next = node[num];
		int cycleCnt = 0;
		if (depth[next] == 0) { // 첫 방문
			depth[next] = depth[num] + 1;
			cycleCnt = dfs(next);
		} else { // 재방문
			cycleCnt = depth[num] - depth[next] + 1;
		}

		depth[num] = 100001;

		return cycleCnt < 0 ? 0 : cycleCnt;

	}
}