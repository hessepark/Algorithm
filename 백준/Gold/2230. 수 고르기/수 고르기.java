import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int r=0;
		//int sum=arr[r]-arr[l];
		int ans=Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
			while(arr[r]-arr[i]<m&&r<n-1) {
				r++;
			}
			int diff=arr[r]-arr[i];
			if(diff>=m)
				ans=Math.min(ans, diff);
		}
		
		System.out.print(ans);

		
	
	}
	

}