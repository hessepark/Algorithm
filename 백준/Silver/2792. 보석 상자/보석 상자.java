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
		
		int k = find(arr, n);
		
		System.out.println(k);
	}
	
	public static int find(int[] arr, int n) {
		
		int l=1;
		int r=1000000000;
		int ans = -1;
		
		while(l<=r) {
			int m=(l+r)/2;
			//System.out.println(m);
			
			if(isPossible(arr,n,m)) {
				r=m-1;
				ans=m;
			}
			else {
				l=m+1;
			}
		}
		
		return ans;
	}
	
	public static boolean isPossible(int[] arr, int n, int m) {
		int sum=0;
		
		for(int i=0;i<arr.length;i++) {
			sum+=(arr[i]+m-1)/m;
		}
		
		//System.out.println("m 출력: "+m +" sum 출력: "+sum);
		
		return sum<=n;
	}

	
}