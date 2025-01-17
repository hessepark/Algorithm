import java.util.Scanner;

class Main {

	public static int dp[][];
	public static int wine[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		dp = new int[3][n + 1];
		wine = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			wine[i] = sc.nextInt();
		}

		dp[0][1] = 0;
		dp[1][1] = wine[1];
		dp[2][1] = wine[1];

		for (int i = 2; i < n + 1; i++) {
			dp[0][i] = Math.max(dp[0][i - 1], Math.max(dp[1][i - 1], dp[2][i - 1]));
			dp[1][i] = dp[0][i - 1] + wine[i];
			dp[2][i] = dp[1][i - 1] + wine[i];
		}

//		for (int i = 1; i <= n; i++) {
//			System.out.print(dp[0][i] + " ");
//		}

		System.out.println(Math.max(dp[0][n], Math.max(dp[1][n], dp[2][n])));

	}
}