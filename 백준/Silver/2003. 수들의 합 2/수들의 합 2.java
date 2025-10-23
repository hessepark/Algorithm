import java.io.IOException;
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
		
		int rightIndex=0;
		int sum=arr[0];
		int cnt=0;
		
		for(int i=0;i<n;i++) {
			while(sum<m&&rightIndex<n-1) {
				sum+=arr[++rightIndex];
			}
			if(sum==m) cnt++;
			sum-=arr[i];
		}
		
		System.out.println(cnt);
		
	}
	

}