import java.util.Scanner;

class Main {

	public static int dp[];
	public static int coin[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		dp = new int[k + 1]; // 가치가 될 수 있는 경우의 수
		coin = new int[n];

		dp[0] = 1;
		
		for (int i = 0; i < n; i++) {
			coin[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
//			
//			for(int j=0;coin[i]+j<=k;j++) {
//				dp[j+coin[i]]+=dp[j];
//			}
			
			for(int j=coin[i];j<=k;j++) {
				dp[j]+=dp[j-coin[i]];
			}
		//	for(int z=0;z<=k;z++) {
		//		System.out.print(dp[z]+" ");
		//	}
		//	System.out.println();
		}
		
		System.out.println(dp[k]);

	}
}