import java.util.Scanner;

class Main {

	public static int n;
	public static int list[];
	public static boolean check[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		int cnt = 0;

		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			list = new int[n + 1];
			check = new boolean[n + 1];
			cnt = 0;

			for (int i = 1; i < n + 1; i++) {
				list[i] = sc.nextInt();
			}

			for (int i = 1; i < n + 1; i++) {
				if (!check[i]) {
					cnt++;
					dfs(i);
				}
			}

			System.out.println(cnt);

		}

	}

	public static void dfs(int num) {
		check[num] = true;

		// System.out.println(num);

		if (!check[list[num]]) {
			dfs(list[num]);
		}

	}
}