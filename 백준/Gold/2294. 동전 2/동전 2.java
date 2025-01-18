import java.util.Scanner;

class Main {

	public static int dp[];
	public static int coin[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		dp = new int[k + 1]; // 만들 수 있는 최소 동전의 수
		coin = new int[n];

		for (int i = 1; i < k + 1; i++) {
			dp[i] = 100001;
		}

		for (int i = 0; i < n; i++) {
			coin[i] = sc.nextInt();
			if (coin[i] <= k) {
				dp[coin[i]] = 1;
			}
		}

		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < n; j++) {
				// i를 알고 있을 때
//				if (i + coin[j] <= k) {
//					dp[i + coin[j]] = Math.min(dp[i + coin[j]], dp[i] + 1);
//				}
				// i를 구하고 싶을 때
				if (i - coin[j] >= 0) {
					dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
				}
			}
		}

		if(dp[k]==100001) {
			System.out.println(-1);
		}
		else
		System.out.println(dp[k]);

	}
}