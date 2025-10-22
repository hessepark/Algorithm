import java.io.IOException;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int arr[]= new int[m];
		
		for(int i=0;i<m;i++) {
			arr[i] = sc.nextInt();
		}
		
		int result = find(arr,n);
		
		System.out.println(result);
		
	}
	
	public static int find(int[] arr, int n) {
	
		int l=1;
		int r=1000000000;
		
		int ans=-1;
		
		while(l<=r) {
			int m =(l+r)/2;
			
			if(isPossible(arr,m,n)) {
				ans=m;
				r=m-1;
			}
			else {
				l=m+1;
			}
		}
		
		return ans;
		
	}
	
	public static boolean isPossible(int[] arr, int m, int n) {
		
		long sum=0;
		
		for(int i=0;i<arr.length;i++) {
			sum+=(arr[i]+m-1)/m;
		}
		
		return sum<=n;
		
	}
	

	
}