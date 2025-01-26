import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		final int NONE = 0;
		final int LEFT = 1;
		final int RIGHT = 2;

		int dp[][] = new int[3][n + 1];

		dp[NONE][1] = 1;
		dp[LEFT][1] = 1;
		dp[RIGHT][1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[NONE][i] = (dp[NONE][i - 1] + dp[LEFT][i - 1] + dp[RIGHT][i - 1])%9901;
			dp[LEFT][i] = (dp[NONE][i - 1] + dp[RIGHT][i - 1])%9901;
			dp[RIGHT][i] = (dp[NONE][i - 1] + dp[LEFT][i - 1])%9901;
		}
		
		System.out.println((dp[NONE][n]+dp[LEFT][n]+dp[RIGHT][n])%9901);

	}
}