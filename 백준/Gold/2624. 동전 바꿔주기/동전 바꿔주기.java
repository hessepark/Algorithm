import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int k = sc.nextInt();

		int[][] dp = new int[k + 1][t + 1];

		dp[0][0] = 1;

		for (int i = 1; i <= k; i++) { // 동전 사용
			int coin = sc.nextInt();
			int coinCnt = sc.nextInt();
			for (int v = 0; v <= t; v++) {
				for (int cnt = 0; cnt <= coinCnt; cnt++) {
					int value = v + cnt * coin;
					if(value>t) break;
					dp[i][value]+=dp[i-1][v];
				}
			}
		}
		
		System.out.println(dp[k][t]);

	}
}