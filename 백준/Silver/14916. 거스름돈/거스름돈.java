import java.util.Scanner;

class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int dp[] = new int[n + 5];
		
		for(int i=1;i<dp.length;i++) {
			dp[i]=Integer.MAX_VALUE;
		}

		dp[2] = 1;
		dp[5] = 1;
		
		int arr[]= {2,5};

		for (int i = 1; i <= n; i++) {

//			if (i - 2 >= 0 && dp[i - 2] != Integer.MAX_VALUE) {
//				dp[i] =Math.min(dp[i],dp[i - 2] + 1);
//			}
//
//			if (i - 5 >= 0 && dp[i - 5] != Integer.MAX_VALUE) {
//				dp[i] = Math.min(dp[i], dp[i - 5] + 1);
//			}
			
			for(int j=0;j<arr.length;j++) {
				if (i- arr[j] >=0 && dp[i-arr[j]]!=Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i-arr[j]]+1);
				}
			}

			// System.out.println(i+": "+dp[i]);

		}

//		if (dp[n] == Integer.MAX_VALUE) {
//			System.out.println(-1);
//		} else {
//			System.out.println(dp[n]);
//		}
		
		System.out.println(dp[n]==Integer.MAX_VALUE?-1:dp[n]);
	}
}