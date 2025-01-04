import java.util.Scanner;

class Main {

	public static int[] nextNode;
	public static boolean[] isVisited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			nextNode = new int[n + 1];
			isVisited = new boolean[n + 1];

			for (int i = 1; i < n + 1; i++) {
				nextNode[i] = sc.nextInt();
			}

			int cnt = 0;
			for (int i = 1; i < n + 1; i++) {
				if (!isVisited[i]) {
					cnt++;
					dfs(i);
				}
			}
			System.out.println(cnt);

		}

	}

	public static void dfs(int num) {

		isVisited[num] = true;

		if (!isVisited[nextNode[num]]) {
			dfs(nextNode[num]);
		}

	}
}