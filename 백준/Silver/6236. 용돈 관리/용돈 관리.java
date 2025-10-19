import java.util.Arrays;
import java.util.Scanner;

class Main{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int max  = Integer.MIN_VALUE;
		
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			max=Math.max(max, arr[i]);
		}
		
		long k = binarySearch(arr,m,max);
		
		System.out.println(k);
		
	}
	
	public static long binarySearch(int[] arr, int m, int max) {
		
		long l=max;
		long r=10000000000L;
		long ans=-1;
		
		while(l<=r) {
			long mid =(l+r)/2;
			long tmp = mid;
			int cnt=1;
			
			for(int i=0;i<arr.length;i++) {
				if(tmp-arr[i]<0) {
					tmp=mid;
					cnt++;
				}
				tmp-=arr[i];
			}
			
			
			if(cnt>m) {
				l=mid+1;
			}
			else {
				ans=mid;
				r=mid-1;
			}
			
			
			//System.out.println("cnt: " + cnt);
			//System.out.println("l: "+l+" r: "+r);
			
		}
		
		return ans;
		
		
	}
	

	
	
}

