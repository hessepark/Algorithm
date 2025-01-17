import java.util.Scanner;

class Main {
	
	public static int dp[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		dp = new int[k+1];
		
		for(int i=0;i<n;i++) {
			int w = sc.nextInt();
			int v = sc.nextInt();
			
			for(int j=k;j-w>=0;j--) {
				dp[j]=Math.max(dp[j], dp[j-w]+v);
			}
		}
		
		System.out.println(dp[k]);
		
	}
}