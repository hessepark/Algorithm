import java.util.Scanner;

class Main {
	
	public static int dp[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		dp=new int[46];
		dp[1]=1;
		for(int i=2;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		
		System.out.println(dp[n]);
		
	}
	

}