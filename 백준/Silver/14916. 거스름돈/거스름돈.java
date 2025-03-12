import java.util.Scanner;

class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int dp[] = new int[n + 5];

		dp[2] = 1;
		dp[5] = 1;

		for (int i = 1; i <= n; i++) {
			

			if (i - 2 >= 0 && dp[i - 2] != 0) {
				dp[i] = dp[i - 2] + 1;
			}

			if (i - 5 >= 0 && dp[i - 5] != 0) {
				dp[i] = Math.min(dp[i], dp[i - 5] + 1);
			}
			
			//System.out.println(i+": "+dp[i]);

		}
		
		if(dp[n]==0) {
			System.out.println(-1);
		}
		else
		System.out.println(dp[n]);

	}
}